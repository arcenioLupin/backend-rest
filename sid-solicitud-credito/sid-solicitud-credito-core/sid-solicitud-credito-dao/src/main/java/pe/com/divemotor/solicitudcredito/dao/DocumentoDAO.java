package pe.com.divemotor.solicitudcredito.dao;

import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;

public interface DocumentoDAO {

    void listar(ListarDocumentosProcedure parametros);
//---I-90028:Dante Artica
     void listarTiposDocumeto(ListarDocumentosProcedure parametros);
     void listarAdjuntosAnteriores(ListarDocumentosProcedure parametros);
//---F-90028:Dante Artica
    public void actualizar(ActualizarDocumentoProcedure parametros);

    public void listarGeneral(ListarDocumentosProcedure parametros);

    public void actualizarGeneral(ActualizarDocumentoProcedure parametros);

    public void listarConsulta(ListarDocumentosProcedure parametros);

    public void actualizarDocumento(ActualizarDocumentoProcedure parametros);
    
    public void listarDocLegales(ListarDocumentosProcedure parametros);
    
    public void listarDocLegalesXCodLeg(ListarDocumentosProcedure parametros);
}
