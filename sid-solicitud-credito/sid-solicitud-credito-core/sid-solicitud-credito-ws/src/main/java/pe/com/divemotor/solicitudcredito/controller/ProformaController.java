package pe.com.divemotor.solicitudcredito.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.solicitudcredito.dto.request.ListaProformaRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ProformaListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ProformaService;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.solicitudcredito.util.Util;

@RestController
@RequestMapping("/api")
public class ProformaController {
    
    private final Logger LOGGER = Logger.getLogger(getClass());
    
    private ProformaService proformaService;

    @Autowired
    public void setProformaService(ProformaService proformaService) {
        this.proformaService = proformaService;
    }

    @ApiOperation(value = "Listar proforma para el registro de solicitud de credito",
            notes = "retorna los datos de una proforma. Procedure PKG_SWEB_CRED_SOLI.SP_LIST_PROFORMA.")
    @RequestMapping(value = "/proforma", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ProformaListadoResponse listar(
            @ApiParam(value = "Código de usuario", required = true, defaultValue = "ACRUZ") @RequestHeader("codUsuario") String codUsuario,
            @ApiParam(value = "Id de usuario", required = true, defaultValue = "901") @RequestHeader("idUsuario") String idUsuario,
            @ApiParam(value = "Token de Autorización", required = true) @RequestHeader("token") String token,
            @ModelAttribute ListaProformaRequest request
    ) {

        HeaderPaginadoParams headerParams = new HeaderPaginadoParams();
        headerParams.setCodUsuario(codUsuario);

        ProformaListadoResponse response = new ProformaListadoResponse();

        try {
            response = proformaService.listar(headerParams, request);

        } catch (Exception ex) { 
            String codigoError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
            LOGGER.error(codigoError, ex);
            response.setEstadoTrama(codigoError);
        }
        return response;
    }
    
}
