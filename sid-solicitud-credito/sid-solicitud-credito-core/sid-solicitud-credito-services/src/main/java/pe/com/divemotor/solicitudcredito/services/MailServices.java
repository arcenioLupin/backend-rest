/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.services;

import java.util.Map;
import pe.com.divemotor.solicitudcredito.dto.response.GenericoResponse;

/**
 *
 * @author lvalderrama.applied
 */
public interface MailServices {

    public GenericoResponse envioCorreos(Map parametros, String tipoRefProc) throws Exception;

}
