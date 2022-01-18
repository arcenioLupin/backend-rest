/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.typehandler;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.jboss.jca.adapters.jdbc.WrappedConnection;
import pe.com.divemotor.solicitudcredito.dominio.ParametrosFlujoCaja;

/**
 *
 * @author mbardales
 */
public class ParametrosFlujoCajaTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        
        List<ParametrosFlujoCaja> parametros = (List<ParametrosFlujoCaja>) parameter;
        
        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;
        
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_LIST_INGR_EGRE_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[parametros.size()];
        
        int contador = 0;
        
        for (ParametrosFlujoCaja parametro : parametros) {
            Object[] params = new Object[6];
            params[0] = parametro.getCodParaFc();
            params[1] = parametro.getIndTipoFc();
            params[2] = parametro.getIndTipo();
            params[3] = parametro.getValPara();
            params[4] = parametro.getNroRuta();
            Clob lob_texto = oracleConn.createClob();
            lob_texto.setString(1, parametro.getValTxt());
            params[5] = lob_texto;
   
            STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
            structs[contador] = struct;
            
            contador = contador + 1;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_LIST_INGR_EGRE", oracleConn);
        ARRAY oracleArray = new ARRAY(desc, oracleConn, structs);
        ps.setArray(i, oracleArray);
    }

    @Override
    public Object getResult(ResultSet rs, String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getResult(ResultSet rs, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getResult(CallableStatement cs, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
