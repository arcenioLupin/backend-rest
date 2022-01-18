/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.generico.util.GenericoConstantes;
import pe.com.divemotor.solicitudcredito.dto.request.ReporteInformacionSBSRequest;

import pe.com.divemotor.solicitudcredito.dto.response.ReporteInformacionSBSResponse;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.DetalleItemSBS12M;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.DetalleItemProtestos;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.DetalleItemRepVencidos;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.InformeSBSDetalleConsolidado;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTDeudaSBS12Item;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTDeudaSBS12ItemDetalleItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalleRepVencidosItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalleRepVencidosItemDocVencItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.SdtProtestosListItem;
import pe.com.divemotor.solicitudcredito.dto.response.sentinel.WSInfoDetalleExecuteResponse;
import pe.com.divemotor.solicitudcredito.reporte.ReporteInformacionSBSExcel;
import pe.com.divemotor.solicitudcredito.reporte.datos.ReporteInformacionSBSExcelDataSource;
import pe.com.divemotor.solicitudcredito.services.ReporteInformacionSBSService;
import pe.com.divemotor.solicitudcredito.util.Constantes;

/**
 *
 * @author avilca
 */
@Service
@Transactional
public class ReporteInformacionSBSServiceImpl implements ReporteInformacionSBSService {

    @Autowired
    private MessageSource messageSource;    
    
    @Override
    public ReporteInformacionSBSResponse exportarReporte(HeaderParams headerParams, ReporteInformacionSBSRequest request) throws Exception {

        ReporteInformacionSBSExcelDataSource response = new ReporteInformacionSBSExcelDataSource();
        ReporteInformacionSBSExcel reporte = new ReporteInformacionSBSExcel();

        RestTemplate restTemplate = new RestTemplate();
        WSInfoDetalleExecuteResponse jsonResponse = new WSInfoDetalleExecuteResponse();        
        
        // HEADERS PARA LLAMAR AL SERVICIO DE SENTINEL
        HttpHeaders headers = new HttpHeaders();
        headers.add("codUsuario", headerParams.getCodUsuario());
        headers.add("token", headerParams.getToken());
        headers.add("idUsuario", headerParams.getIdUsuario().toString());
        HttpEntity entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.messageSource.getMessage(Constantes.URL_WS_SENTINEL, null, null))
                .queryParam("tipoDocumento", request.getTipoDocumento())
                .queryParam("nroDocumento", request.getNroDocumento());

        jsonResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                WSInfoDetalleExecuteResponse.class).getBody();

        // BEAN FINAL
        InformeSBSDetalleConsolidado objInformeSBSDetalleConsolidado = new InformeSBSDetalleConsolidado();

        // LISTAS PARA EL BEAN FINAL
        List<DetalleItemSBS12M> listaDetalleItemSBS12M = new ArrayList<>();
        List<DetalleItemProtestos> listaDetalleProtAcepSinRegu = new ArrayList<>();
        List<DetalleItemProtestos> listaDetalleProtGiradorSinRegu = new ArrayList<>();
        List<DetalleItemProtestos> listaDetalleProtAcepRegu = new ArrayList<>();
        List<DetalleItemProtestos> listaDetalleProtGiradorRegu = new ArrayList<>();
        List<DetalleItemRepVencidos> listaDetalleRepVencidos = new ArrayList<>();

        // CONTADORES
        int contadorSBS12M = 0;

        objInformeSBSDetalleConsolidado.setNomRazSoc(jsonResponse.getInfodetalle().getNomRazSoc());
        objInformeSBSDetalleConsolidado.setCondicionContribuyente(jsonResponse.getInfodetalle().getCondicionContribuyente());
        objInformeSBSDetalleConsolidado.setCalificativo(jsonResponse.getInfodetalle().getCalificativo());

        // DETALLE DE DEUDA DE SBS12M
        //<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        for (SDTDeudaSBS12Item objSDTDeudaSBS12SDTDeudaSBS12Item : jsonResponse.getInfodetalle().getSbsmicrof12M().getSDTDeudaSBS12Item()) {
            contadorSBS12M = contadorSBS12M + 1;
            for (SDTDeudaSBS12ItemDetalleItem objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux : objSDTDeudaSBS12SDTDeudaSBS12Item.getDetalle().getDetalleItem()) {
                if (contadorSBS12M == 1) {
                    DetalleItemSBS12M objDetalleItemSBS12M = new DetalleItemSBS12M();
                    objDetalleItemSBS12M.setAnio(objSDTDeudaSBS12SDTDeudaSBS12Item.getAnio());
                    objDetalleItemSBS12M.setMes(objSDTDeudaSBS12SDTDeudaSBS12Item.getMes());
                    objDetalleItemSBS12M.setCalificacion(objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux.getCalificacion());
                    objDetalleItemSBS12M.setDiasVen(objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux.getDiasVen());
                    objDetalleItemSBS12M.setEntidad(objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux.getEntidad());
                    objDetalleItemSBS12M.setFecha(objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux.getFecha());
                    objDetalleItemSBS12M.setSaldo(objSDTDeudaSBS12SDTDeudaSBS12ItemDetalleItemAux.getSaldo());
                    listaDetalleItemSBS12M.add(objDetalleItemSBS12M);
                }
            }
        }
        //<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        objInformeSBSDetalleConsolidado.setListaDetalleItemSBS12M(listaDetalleItemSBS12M);

        // DETALLE DE DEUDA DE PROTESTOS ACEPTANTES SIN REGULARIZAR
        //<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        for (SdtProtestosListItem objSdtProtestosListSdtProtestosListItem : jsonResponse.getInfodetalle().getProtestosAceptantesSinRegularizar().getSdtProtestosListItem()) {
            DetalleItemProtestos objProtestosAcepRegu = new DetalleItemProtestos();
            objProtestosAcepRegu.setTipoDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoAcre());
            objProtestosAcepRegu.setNroDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getNroDocumentoAcre());
            objProtestosAcepRegu.setRazonSocialAcre(objSdtProtestosListSdtProtestosListItem.getRazonSocialAcre());
            objProtestosAcepRegu.setNroDocumetos(objSdtProtestosListSdtProtestosListItem.getNroDocumetos());
            objProtestosAcepRegu.setTipoDocumentoProtestado(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoProtestado());
            objProtestosAcepRegu.setMonedaDocumento(objSdtProtestosListSdtProtestosListItem.getMonedaDocumento());
            objProtestosAcepRegu.setMontoDocumento(objSdtProtestosListSdtProtestosListItem.getMontoDocumento());
            objProtestosAcepRegu.setMontoSoles(objSdtProtestosListSdtProtestosListItem.getMontoSoles());
            objProtestosAcepRegu.setFechaProtesto(objSdtProtestosListSdtProtestosListItem.getFechaProtesto());
            objProtestosAcepRegu.setFechaVencimiento(objSdtProtestosListSdtProtestosListItem.getFechaVencimiento());
            objProtestosAcepRegu.setDiaVencidos(objSdtProtestosListSdtProtestosListItem.getDiaVencidos());
            listaDetalleProtAcepSinRegu.add(objProtestosAcepRegu);

        }
       //<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        objInformeSBSDetalleConsolidado.setListaProtestosAceptantesSinRegu(listaDetalleProtAcepSinRegu);

        // DETALLE DE DEUDA DE PROTESTOS GIRADOR SIN REGULARIZAR
        //<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        for (SdtProtestosListItem objSdtProtestosListSdtProtestosListItem : jsonResponse.getInfodetalle().getProtestosGiradorSinRegularizar().getSdtProtestosListItem()) {
            DetalleItemProtestos objProtestosAcepRegu = new DetalleItemProtestos();
            objProtestosAcepRegu.setTipoDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoAcre());
            objProtestosAcepRegu.setNroDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getNroDocumentoAcre());
            objProtestosAcepRegu.setRazonSocialAcre(objSdtProtestosListSdtProtestosListItem.getRazonSocialAcre());
            objProtestosAcepRegu.setNroDocumetos(objSdtProtestosListSdtProtestosListItem.getNroDocumetos());
            objProtestosAcepRegu.setTipoDocumentoProtestado(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoProtestado());
            objProtestosAcepRegu.setMonedaDocumento(objSdtProtestosListSdtProtestosListItem.getMonedaDocumento());
            objProtestosAcepRegu.setMontoDocumento(objSdtProtestosListSdtProtestosListItem.getMontoDocumento());
            objProtestosAcepRegu.setMontoSoles(objSdtProtestosListSdtProtestosListItem.getMontoSoles());
            objProtestosAcepRegu.setFechaProtesto(objSdtProtestosListSdtProtestosListItem.getFechaProtesto());
            objProtestosAcepRegu.setFechaVencimiento(objSdtProtestosListSdtProtestosListItem.getFechaVencimiento());
            objProtestosAcepRegu.setDiaVencidos(objSdtProtestosListSdtProtestosListItem.getDiaVencidos());
            listaDetalleProtGiradorSinRegu.add(objProtestosAcepRegu);

        }
          //<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        objInformeSBSDetalleConsolidado.setListaProtestosGiradorSinRegu(listaDetalleProtGiradorSinRegu);

        // DETALLE DE DEUDA DE PROTESTOS ACEPTANTES REGULARIZADOS
        for (SdtProtestosListItem objSdtProtestosListSdtProtestosListItem : jsonResponse.getInfodetalle().getProtestosAceptantesRegularizado().getSdtProtestosListItem()) {
            DetalleItemProtestos objProtestosAcepRegu = new DetalleItemProtestos();
            objProtestosAcepRegu.setTipoDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoAcre());
            objProtestosAcepRegu.setNroDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getNroDocumentoAcre());
            objProtestosAcepRegu.setRazonSocialAcre(objSdtProtestosListSdtProtestosListItem.getRazonSocialAcre());
            objProtestosAcepRegu.setNroDocumetos(objSdtProtestosListSdtProtestosListItem.getNroDocumetos());
            objProtestosAcepRegu.setTipoDocumentoProtestado(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoProtestado());
            objProtestosAcepRegu.setMonedaDocumento(objSdtProtestosListSdtProtestosListItem.getMonedaDocumento());
            objProtestosAcepRegu.setMontoDocumento(objSdtProtestosListSdtProtestosListItem.getMontoDocumento());
            objProtestosAcepRegu.setMontoSoles(objSdtProtestosListSdtProtestosListItem.getMontoSoles());
            objProtestosAcepRegu.setFechaProtesto(objSdtProtestosListSdtProtestosListItem.getFechaProtesto());
            objProtestosAcepRegu.setFechaVencimiento(objSdtProtestosListSdtProtestosListItem.getFechaVencimiento());
            objProtestosAcepRegu.setDiaVencidos(objSdtProtestosListSdtProtestosListItem.getDiaVencidos());
            listaDetalleProtAcepRegu.add(objProtestosAcepRegu);

        }

        objInformeSBSDetalleConsolidado.setListaProtestosAceptantesRegu(listaDetalleProtAcepRegu);

        // DETALLE DE DEUDA DE PROTESTOS GIRADOR REGULARIZADOS
        //<I Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        for (SdtProtestosListItem objSdtProtestosListSdtProtestosListItem : jsonResponse.getInfodetalle().getProtestosGiradorRegularizado().getSdtProtestosListItem()) {
            DetalleItemProtestos objProtestosAcepRegu = new DetalleItemProtestos();
            objProtestosAcepRegu.setTipoDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoAcre());
            objProtestosAcepRegu.setNroDocumentoAcre(objSdtProtestosListSdtProtestosListItem.getNroDocumentoAcre());
            objProtestosAcepRegu.setRazonSocialAcre(objSdtProtestosListSdtProtestosListItem.getRazonSocialAcre());
            objProtestosAcepRegu.setNroDocumetos(objSdtProtestosListSdtProtestosListItem.getNroDocumetos());
            objProtestosAcepRegu.setTipoDocumentoProtestado(objSdtProtestosListSdtProtestosListItem.getTipoDocumentoProtestado());
            objProtestosAcepRegu.setMonedaDocumento(objSdtProtestosListSdtProtestosListItem.getMonedaDocumento());
            objProtestosAcepRegu.setMontoDocumento(objSdtProtestosListSdtProtestosListItem.getMontoDocumento());
            objProtestosAcepRegu.setMontoSoles(objSdtProtestosListSdtProtestosListItem.getMontoSoles());
            objProtestosAcepRegu.setFechaProtesto(objSdtProtestosListSdtProtestosListItem.getFechaProtesto());
            objProtestosAcepRegu.setFechaVencimiento(objSdtProtestosListSdtProtestosListItem.getFechaVencimiento());
            objProtestosAcepRegu.setDiaVencidos(objSdtProtestosListSdtProtestosListItem.getDiaVencidos());
            listaDetalleProtGiradorRegu.add(objProtestosAcepRegu);

        }
         //<F Req. 87567 E2.1 ID 88-89 AVILCA 03/08/2020>
        objInformeSBSDetalleConsolidado.setListaProtestosGiradorRegu(listaDetalleProtGiradorRegu);

        // DETALLE DE VENCIDOS
        for (SDTInfoDetalleRepVencidosItem objSDTInfoDetalleRepVencidosItem : jsonResponse.getInfodetalle().getRepVencidos().getRepVencidosItem()) {
            for (SDTInfoDetalleRepVencidosItemDocVencItem objSDTInfoDetalleRepVencidosItemDocVencItem : objSDTInfoDetalleRepVencidosItem.getDocVen().getDocVencItem()) {
                for (SDTInfoDetalleRepVencidosItemDocVencItemDetalleItem objSDTInfoDetalleRepVencidosItemDocVencItemDetalleItem : objSDTInfoDetalleRepVencidosItemDocVencItem.getDetalle().getDetalleItem()) {
                    DetalleItemRepVencidos objDetalleItemRepVencidos = new DetalleItemRepVencidos();
                    objDetalleItemRepVencidos.setDocVenNom(objSDTInfoDetalleRepVencidosItemDocVencItem.getDocVenNom());
                    objDetalleItemRepVencidos.setDocVenDeuTot(objSDTInfoDetalleRepVencidosItemDocVencItem.getDocVenDeuTot());
                    objDetalleItemRepVencidos.setDocVenDiaAtr(objSDTInfoDetalleRepVencidosItemDocVencItem.getDocVenDiaAtr());
                    objDetalleItemRepVencidos.setRazSoc(objSDTInfoDetalleRepVencidosItemDocVencItemDetalleItem.getRazSoc());
                    objDetalleItemRepVencidos.setMonDeuVen(objSDTInfoDetalleRepVencidosItemDocVencItemDetalleItem.getMonDeuVen());
                    objDetalleItemRepVencidos.setNumDocRep(objSDTInfoDetalleRepVencidosItemDocVencItemDetalleItem.getNumDocRep());
                    objDetalleItemRepVencidos.setNumDiaVen(objSDTInfoDetalleRepVencidosItemDocVencItemDetalleItem.getNumDiaVen());
                    listaDetalleRepVencidos.add(objDetalleItemRepVencidos);
                }
            }
        }

        objInformeSBSDetalleConsolidado.setListaDetalleRepVencidos(listaDetalleRepVencidos);

        byte[] excelByte = reporte.generarReporte(response, objInformeSBSDetalleConsolidado);

        ReporteInformacionSBSResponse reporteResponse = new ReporteInformacionSBSResponse();
        reporteResponse.setEstadoTrama(GenericoConstantes.ESTADO_TRAMA_OK);
        reporteResponse.setMensaje("El reporte se ha generado exitosamente.");
        reporteResponse.setReporteBytes(excelByte);
        reporteResponse.setReporte(Base64.encodeBase64String(excelByte));

        return reporteResponse;

    }

}
