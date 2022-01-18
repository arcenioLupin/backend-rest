package pe.com.divemotor.solicitudcredito.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ListarDocumentosProcedure;
import pe.com.divemotor.solicitudcredito.mapper.DocumentoMapper;
import pe.com.divemotor.solicitudcredito.dao.DocumentoDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.documento.ActualizarDocumentoProcedure;

@Repository
public class DocumentoDAOImpl implements DocumentoDAO {

    private DocumentoMapper documentoMapper;

    @Autowired
    public void setDocumentoMapper(DocumentoMapper documentoMapper) {
        this.documentoMapper = documentoMapper;
    }

    @Override
    public void listar(ListarDocumentosProcedure parametros) {
        documentoMapper.listar(parametros);
    }
//---I-90028:Dante Artica
      @Override
    public void listarTiposDocumeto(ListarDocumentosProcedure parametros) {
        documentoMapper.listarTiposDocumeto(parametros);
    }
     @Override
    public void listarAdjuntosAnteriores(ListarDocumentosProcedure parametros) {
        documentoMapper.listarAdjuntosAnteriores(parametros);
    }
//---F-90028:Dante Artica    
    @Override
    public void actualizar(ActualizarDocumentoProcedure parametros) {
        documentoMapper.actualizar(parametros);
    }

    @Override
    public void listarGeneral(ListarDocumentosProcedure parametros) {
        documentoMapper.listarGeneral(parametros);
    }

    @Override
    public void actualizarGeneral(ActualizarDocumentoProcedure parametros) {
        documentoMapper.actualizarGeneral(parametros);
    }

    @Override
    public void listarConsulta(ListarDocumentosProcedure parametros) {
        documentoMapper.listarConsulta(parametros);
    }

    @Override
    public void actualizarDocumento(ActualizarDocumentoProcedure parametros) {
        documentoMapper.actualizarDocumento(parametros);
    }
    
    @Override
     public void listarDocLegales(ListarDocumentosProcedure parametros){
         documentoMapper.listarDocLegales(parametros);
     }
     
     @Override
     public void listarDocLegalesXCodLeg(ListarDocumentosProcedure parametros){
         documentoMapper.listarDocLegales(parametros);
     }

}
