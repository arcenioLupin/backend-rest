package pe.com.divemotor.solicitudcredito.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.com.divemotor.solicitudcredito.dao.MaestroDAO;
import pe.com.divemotor.solicitudcredito.dominio.Correo;
import pe.com.divemotor.solicitudcredito.dto.procedure.maestro.ListarMaestroProcedure;
import pe.com.divemotor.solicitudcredito.dto.response.CorreoResponse;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;
import pe.com.divemotor.solicitudcredito.mapper.MaestroMapper;

@Repository("maestroDAO")
public class MaestroDAOImpl implements MaestroDAO {

    private MaestroMapper maestroMapper;

    protected transient final Logger log = Logger.getLogger(getClass());

    @Autowired
    public void setMaestroMapper(MaestroMapper maestroMapper) {
        this.maestroMapper = maestroMapper;
    }

    @Override
    public GenericoResponse crearPlantillaEvento(Map parametros) throws Exception {
        maestroMapper.crearPlantillaEvento(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }

    @Override
    public CorreoResponse obtenerPlantillaCorreo(Map parametros) throws Exception {
        maestroMapper.obtenerPlantillaCorreo(parametros);
        List<Correo> listadoQuery = (List<Correo>) parametros.get("listaCorreo");
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        CorreoResponse response = new CorreoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setListadoCorreos(listadoQuery);
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }

    @Override
    public GenericoResponse actualizarEstadoEnvio(Map parametros) throws Exception {
        maestroMapper.actualizarEstadoEnvio(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }

    @Override
    public void listar(ListarMaestroProcedure parametros) {
        maestroMapper.listar(parametros);
    }
    
    @Override
    public void listarFilialZona(ListarMaestroProcedure parametros) {
        maestroMapper.listarFilialZona(parametros);
    }


    @Override
    public GenericoResponse crearPlantillaAprobacion(Map parametros) throws Exception {
        maestroMapper.crearPlantillaAprobacion(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }

    @Override
    public GenericoResponse crearPlantillaSegAprobacion(Map parametros) throws Exception {
        maestroMapper.crearPlantillaSegAprobacion(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }
     //I Req. 87567 E2.1 ID## avilca 06/10/2020>
    @Override
    public GenericoResponse crearPlantillaSegRechazo(Map parametros) throws Exception {
        maestroMapper.crearPlantillaSegRechazo(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    } 
    
    @Override
    public GenericoResponse crearPlantillaSegAprob(Map parametros) throws Exception {
        maestroMapper.crearPlantillaSegAprob(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }     
 //F Req. 87567 E2.1 ID## avilca 06/10/2020>
    @Override
    public GenericoResponse crearPlantillaSoliAprobacionCredito(Map parametros) throws Exception {
        maestroMapper.crearPlantillaSoliAprobacionCredito(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }
    
    @Override
    public GenericoResponse crearPlantillaOperacionLxC(Map parametros) throws Exception {
        maestroMapper.crearPlantillaOperacionLxC(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }    

    @Override
    public GenericoResponse crearPlantillaSoliAprobacionCreditoUsu(Map parametros) throws Exception {
        maestroMapper.crearPlantillaSoliAprobacionCreditoUsu(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }
    
    @Override
    public GenericoResponse crearPlantillaVencimientoPoliza(Map parametros) throws Exception {
        maestroMapper.crearPlantillaVencimientoPoliza(parametros);
        int statusQuery = (Integer) parametros.get("status");
        String mensajeQuery = (String) parametros.get("mensaje");
        int correlativoPlantilla = (Integer) parametros.get("correlativoCorreo");
        GenericoResponse response = new GenericoResponse();
        if (statusQuery == 1 || statusQuery == 0) {
            response.setEstadoTrama(String.valueOf(statusQuery));
            response.setMensaje(mensajeQuery);
            response.setCodigo("" + correlativoPlantilla);
            return response;
        } else {
            throw new Exception(mensajeQuery);
        }
    }
}
