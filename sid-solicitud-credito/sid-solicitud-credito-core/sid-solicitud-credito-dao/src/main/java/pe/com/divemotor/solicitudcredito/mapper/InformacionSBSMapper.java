/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.mapper;

import pe.com.divemotor.solicitudcredito.dto.procedure.ListarInformacionSBSProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.RegistrarInformacionSBSProcedure;

/**
 *
 * @author legutierrez
 */
public interface InformacionSBSMapper {
    
    void registrar (RegistrarInformacionSBSProcedure parametros);
    
    void listar (ListarInformacionSBSProcedure parametros);
}
