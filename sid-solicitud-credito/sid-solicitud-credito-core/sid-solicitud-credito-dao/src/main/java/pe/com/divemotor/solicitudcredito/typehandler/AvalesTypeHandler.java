/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import oracle.jdbc.OracleConnection;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.jboss.jca.adapters.jdbc.WrappedConnection;
import pe.com.divemotor.solicitudcredito.dominio.Aval;

/**
 *
 * @author mbardales
 */
public class AvalesTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        List<Aval> avales = (List<Aval>) parameter;

        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;

        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_AVAL_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[avales.size()];
        
        int contador = 0;
        
        for (Aval aval : avales) {
            Object[] params = new Object[11];
            params[0] = aval.getNoCia();
            params[1] = aval.getCodOper();
            params[2] = aval.getSecAval();
            params[3] = aval.getNomAval();
            params[4] = aval.getDirecAval();
            params[5] = aval.getLe();
            params[6] = aval.getTelfAval();
            params[7] = aval.getDesAval();
            params[8] = aval.getNoSoli();
            params[9] = aval.getRuc();
            params[10] = aval.getRepresentante();
            STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
            structs[contador] = struct;
            contador = contador + 1;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_AVAL", oracleConn);
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
