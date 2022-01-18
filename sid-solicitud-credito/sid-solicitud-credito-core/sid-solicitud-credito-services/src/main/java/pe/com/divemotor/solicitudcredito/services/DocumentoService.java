package pe.com.divemotor.solicitudcredito.services;

import pe.com.divemotor.generico.dto.BaseResponse;
import pe.com.divemotor.generico.dto.HeaderPaginadoParams;
import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dto.request.DocumentoRequest;
import pe.com.divemotor.solicitudcredito.dto.response.DocumentoListadoResponse;

public interface DocumentoService {

    public DocumentoListadoResponse listar(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception;
    //---I-90028:Dante Artica
    public DocumentoListadoResponse listarTiposDocumeto(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception;
    public DocumentoListadoResponse listarAdjuntosAnteriores(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil) throws Exception;
    //---F-90028:Dante Artica
    public BaseResponse actualizar(HeaderParams headerParams, DocumentoRequest request) throws Exception;
    
    public BaseResponse eliminar(HeaderParams headerParams, DocumentoRequest request) throws Exception;

    public DocumentoListadoResponse listarGeneral(HeaderParams headerParams, String codSoliCred, String indMancomunado, String codTipoPerso, String codEstadoCivil, String tipoDocu,String codProceso,String indTipoDocu) throws Exception;
    
    public BaseResponse actualizarGeneral(HeaderParams headerParams, DocumentoRequest request) throws Exception;
    
    public BaseResponse eliminarGeneral(HeaderParams headerParams, DocumentoRequest request) throws Exception;
    
    public DocumentoListadoResponse listarConsulta(HeaderPaginadoParams headerParams, DocumentoRequest request) throws Exception;

    public BaseResponse actualizarDocumento(HeaderParams headerParams, DocumentoRequest request) throws Exception;
    
    public DocumentoListadoResponse listarDocLegales(HeaderParams headerParams, String indTipoDocu) throws Exception;
    
    public DocumentoListadoResponse listarDocLegalesXCodLeg(HeaderParams headerParams, String codDocLeg) throws Exception; 
}
