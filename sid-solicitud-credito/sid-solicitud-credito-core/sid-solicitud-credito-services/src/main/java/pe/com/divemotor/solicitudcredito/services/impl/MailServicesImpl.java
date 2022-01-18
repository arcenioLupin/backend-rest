/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.Arrays;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.Adjunto;
import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.solicitudcredito.services.MailServices;
import pe.com.divemotor.generico.dto.CorreoParams;
import pe.com.divemotor.generico.services.CorreoServices;
import pe.com.divemotor.generico.services.impl.CorreoServicesImpl;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.generico.util.MessageSourceUtil;
import pe.com.divemotor.solicitudcredito.dao.EventoDAO;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.dto.response.CorreoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.dao.MaestroDAO;
import pe.com.divemotor.solicitudcredito.dao.SimuladorDAO;
import pe.com.divemotor.solicitudcredito.dominio.Correo;
import pe.com.divemotor.solicitudcredito.dto.procedure.evento.GenerarPlantillaEventoNotariaRegistroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.simulador.GenerarPlantillaCambioTasaSeguroProcedure;

/**
 *
 * @author lvalderrama.applied
 */
@Service("mailServices")
@Transactional
public class MailServicesImpl implements MailServices {

    private static final Logger log = Logger.getLogger(MailServicesImpl.class);

    @Resource(name = "maestroDAO")
    MaestroDAO maestroDAO;

    @Resource(name = "simuladorDAO")
    SimuladorDAO simuladorDAO;
    //inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    @Resource(name = "eventoDAO")
     EventoDAO eventoDAO;
    // fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    //<I-89692>
    @Autowired     
    private MessageSource messageSource;
    //<F-89692>
    
    @Override
    public GenericoResponse envioCorreos(Map parametros, String tipoRefProc) throws Exception {

        GenericoResponse respuesta = new GenericoResponse();
        CorreoResponse rpListaCorreos = new CorreoResponse();
        CorreoServices genericMail = new CorreoServicesImpl();

        try {
            // CREACION DE PLANTILLA
            GenericoResponse rpPlantilla = crearPlantillaCorreo(parametros, tipoRefProc);

            // OBTENER PLANTILLA GENERADA
            if (rpPlantilla.getEstadoTrama().equals(String.valueOf(Constantes.ESTADO_TRAMA_OK))) {
                parametros.put("codCorreoProf", Integer.parseInt(rpPlantilla.getCodigo()));
                rpListaCorreos = maestroDAO.obtenerPlantillaCorreo(parametros);
            }

            // ENVIAR CORREO            
            if (rpListaCorreos.getEstadoTrama().equals(String.valueOf(Constantes.ESTADO_TRAMA_OK)) 
                    && rpListaCorreos.getListadoCorreos().size() > 0) {
                for (Correo item : rpListaCorreos.getListadoCorreos()) {
                    CorreoParams correoParams = new CorreoParams();
                    correoParams.setCorreoDesde(Constantes.COD_CORREO_FROM);
                    correoParams.setCorreosPara(Arrays.asList(item.getDestinatarios()));
                    correoParams.setCorreosCopia(Arrays.asList(item.getCopia()));
                    correoParams.setAsunto(item.getAsunto());
                    correoParams.setCuerpoHTML(item.getCuerpo());
                    //<I-89692>                         
                    correoParams.setHost(MessageSourceUtil.getMessage(messageSource, GenericoConstantes.MAIL_SPARKPOST_HOST));
                    correoParams.setPort(MessageSourceUtil.getMessage(messageSource, GenericoConstantes.MAIL_SPARKPOST_PORT));
                    //<F-89692>
                    if (parametros.get("adjuntos") != null) {
                        switch (tipoRefProc) {
                            case "SOL_APROB_CRED":
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("propuesta.pdf", (byte[]) parametros.get("adjuntos")));
                                break;
                            case "SOL_APROB_CRED_USU":
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("resumen-ejecutivo.xls", (byte[]) parametros.get("adjuntos")));
                                break; 
                            case "OPERACION_LXC":
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("checklist-operacion_lxc.xls", (byte[]) parametros.get("adjuntos")));
                                break;     
                            case "SEG_APROB":
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("factura-seguros.pdf", (byte[])  parametros.get("adjuntos")));
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("seguro-trama.xls", (byte[])  parametros.get("adjuntoTrama")));
                                break;
                            default:
                                correoParams.addAdjunto(Adjunto.buildAdjuntoPdf("ArchivoAdjunto.pdf", (byte[]) parametros.get("adjuntos")));
                                break;
                        }

                    }

                    // ACTUALIZAR ESTADO ENVIO
                    BaseResponse response = genericMail.enviarCorreo(correoParams);
                    if (response.getEstadoTrama().equals(String.valueOf(Constantes.ESTADO_TRAMA_OK))) {
                        maestroDAO.actualizarEstadoEnvio(parametros);
                    } else {
                        if (log.isInfoEnabled()) {
                            log.info("Hubo un error al envio de correo [" + BeanUtils.describe(parametros) + "]");
                        }
                    }
                    
                    respuesta.setCodigo(response.getCodigo());
                    respuesta.setMensaje(response.getMensaje());
                    respuesta.setEstadoTrama(response.getEstadoTrama());
                }
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return respuesta;
    }

    private GenericoResponse crearPlantillaCorreo(Map parametros, String tipoRefProc) {
        GenericoResponse response = new GenericoResponse();

        try {
            if (log.isDebugEnabled()) {
                log.debug("crearPlantillaCorreo input [1 .- " + BeanUtils.describe(parametros) + ", 2.- " + tipoRefProc + "  ]");
            }

            switch (tipoRefProc) {
                case "SOL_APROB":
                    response = maestroDAO.crearPlantillaAprobacion(parametros);
                    break;
                case "SEG_APROB":
                    response = maestroDAO.crearPlantillaSegAprobacion(parametros);
                    break;
                //I Req. 87567 E2.1 ID## avilca 06/10/2020    
                case "SEG_RECH":
                    response = maestroDAO.crearPlantillaSegRechazo(parametros);
                    break;  
                case "SEG_APRB":
                    response = maestroDAO.crearPlantillaSegAprob(parametros);
                    break;                     
                //F Req. 87567 E2.1 ID## avilca 06/10/2020    
                case "SOL_APROB_CRED":
                    response = maestroDAO.crearPlantillaSoliAprobacionCredito(parametros);
                    break;
                case "OPERACION_LXC":
                    response = maestroDAO.crearPlantillaOperacionLxC(parametros);
                    break;                    
                case "SOL_APROB_CRED_USU":
                    response = maestroDAO.crearPlantillaSoliAprobacionCreditoUsu(parametros);
                    break;
                case Constantes.COD_PLANTILLA_REFERENCIA_PROCESO_EVENTO_SOLICITUD_CREDITO:
                    response = maestroDAO.crearPlantillaEvento(parametros);
                    break;
                case Constantes.COD_PLANTILLA_REFERENCIA_PROCESO_CAMBIO_TASA_SEGURO:
                    GenerarPlantillaCambioTasaSeguroProcedure request = new GenerarPlantillaCambioTasaSeguroProcedure();
                    request.setCodSoliCred((String) parametros.get("codSoliCred"));
                    request.setCodUsuario((String) parametros.get("codUsuario"));
                    request.setIdUsuario((Integer) parametros.get("idUsuario"));
                    response = simuladorDAO.generarPlantillaCambioTasaSeguro(request);
                    break;

                case "SEG_VCTO":
                    response = maestroDAO.crearPlantillaVencimientoPoliza(parametros);
                    break;

                    //inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
                case Constantes.COD_PLANTILLA_REFERENCIA_PROCESO_EVENTOS_NOTARIA_REGISTRO:
                    GenerarPlantillaEventoNotariaRegistroProcedure requests = new GenerarPlantillaEventoNotariaRegistroProcedure();
                    requests.setCodSoliCred((String) parametros.get("codSoliCred"));
                    requests.setCodOperRel((String) parametros.get("codOperRel"));
                    requests.setCodUsuario((String) parametros.get("codUsuario"));
                    response = eventoDAO.generarPlantillaEventoNotariaRegistro(requests);
                    break;
                    // fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
                default:
                    break;
            }

            if (log.isDebugEnabled()) {
                log.debug("crearPlantillaCorreo output [1 .- " + BeanUtils.describe(response) + " ]");
            }

        } catch (Exception e) {
            log.info("crearPlantillaCorreo " + e.getMessage());
        }
        return response;
    }
}