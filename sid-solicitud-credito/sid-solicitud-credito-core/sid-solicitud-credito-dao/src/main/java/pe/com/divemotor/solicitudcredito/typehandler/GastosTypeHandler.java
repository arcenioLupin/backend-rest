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
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.jboss.jca.adapters.jdbc.WrappedConnection;
import pe.com.divemotor.solicitudcredito.dominio.GastosLxC;

/**
 *
 * @author mbardales
 */
public class GastosTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        List<GastosLxC> gastos = (List<GastosLxC>) parameter;

        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;

        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_GASTOS_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[gastos.size()];
        
        int contador = 0;
        
        for (GastosLxC gasto : gastos) {
            Object[] params = new Object[10];
            params[0] = null;
            params[1] = gasto.getCodGasto();
            params[2] = null;
            params[3] = gasto.getMonto();
            params[4] = gasto.getMoneda();
            params[5] = null;
            params[6] = null;
            params[7] = null;
            params[8] = null;
            params[9] = null;
            
            STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
            structs[contador] = struct;
            contador = contador + 1;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_GASTOS", oracleConn);
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
