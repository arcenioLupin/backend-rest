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
import pe.com.divemotor.solicitudcredito.dominio.FactorPorMesFlujoCaja;

/**
 *
 * @author mbardales
 */
public class FactorPorMesTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        
        List<FactorPorMesFlujoCaja> factores = (List<FactorPorMesFlujoCaja>) parameter;
        
        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;
        
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_LIST_FACT_MES_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[factores.size()];
        
        int contador = 0;
        
        for (FactorPorMesFlujoCaja factor : factores) {
            Object[] params = new Object[5];
            params[0] = factor.getFecMesIniRang();
            params[1] = factor.getFecMesFinRang();
            params[2] = factor.getValFact();
            params[3] = factor.getIndIngrEgre();
            params[4] = factor.getNroOrde();
   
            STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
            structs[contador] = struct;
            
            contador = contador + 1;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_LIST_FACT_MES", oracleConn);
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
