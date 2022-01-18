package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;

public interface DocumentoMapper {

    void listar(ListarDocumentosProcedure parametros);
//---I-90028:Dante Artica
    void listarTiposDocumeto(ListarDocumentosProcedure parametros);
    void listarAdjuntosAnteriores(ListarDocumentosProcedure parametros);
//---F-90028:Dante Artica
    public void actualizar(ActualizarDocumentoProcedure parametros);

    void listarGeneral(ListarDocumentosProcedure parametros);

    public void actualizarGeneral(ActualizarDocumentoProcedure parametros);

    void listarConsulta(ListarDocumentosProcedure parametros);

    public void actualizarDocumento(ActualizarDocumentoProcedure parametros);
    
    void listarDocLegales(ListarDocumentosProcedure parametros);
}
