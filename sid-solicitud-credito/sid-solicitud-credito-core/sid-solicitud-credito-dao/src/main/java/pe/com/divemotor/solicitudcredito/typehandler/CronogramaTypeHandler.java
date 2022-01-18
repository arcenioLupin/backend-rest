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
import pe.com.divemotor.solicitudcredito.dominio.SimuladorCronograma;

public class CronogramaTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        List<SimuladorCronograma> cuotas = (List<SimuladorCronograma>) parameter;

        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;

        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_CRONO_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[cuotas.size()];
        for (SimuladorCronograma cuota : cuotas) {
            Object[] params = new Object[15];
            params[0] = cuota.getCodNumeLetr();
            params[1] = cuota.getFecVenc();
            params[2] = cuota.getItem();
            params[3] = cuota.getSaldoInicial();
            params[4] = cuota.getCapital();
            params[5] = cuota.getInteres();
            params[6] = cuota.getCuota();
            params[7] = cuota.getSaldoFinal();
            params[8] = cuota.getfVcto();
            params[9] = cuota.getIgv();
            params[10] = cuota.getSeguro();
            params[11] = cuota.getCobranzas();
            params[12] = cuota.getInteresMoratorio();
            params[13] = cuota.getInteresCompensatorio();
            params[14] = cuota.getCostoTraslado();
            STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
            structs[cuota.getCodNumeLetr() - 1] = struct;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_CRONO", oracleConn);
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
