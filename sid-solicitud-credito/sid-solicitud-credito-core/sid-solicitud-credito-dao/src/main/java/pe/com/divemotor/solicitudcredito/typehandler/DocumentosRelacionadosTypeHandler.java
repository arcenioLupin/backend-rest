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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.jboss.jca.adapters.jdbc.WrappedConnection;
import pe.com.divemotor.solicitudcredito.dominio.DocumentosRelacionados;

/**
 *
 * @author mbardales
 */
public class DocumentosRelacionadosTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jt) throws SQLException {
        List<DocumentosRelacionados> documentos = (List<DocumentosRelacionados>) parameter;

        Connection dsConn = ((WrappedConnection) ps.getConnection()).getUnderlyingConnection();
        OracleConnection oracleConn = (OracleConnection) dsConn;

        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("VENTA.VVE_TYPE_DOCU_RELA_ITEM", oracleConn);
        STRUCT[] structs = new STRUCT[documentos.size()];
        
        int contador = 0;
        
        for (DocumentosRelacionados documento : documentos) {
            try {
                Object[] params = new Object[15];
                params[0] = null;
                params[1] = null;
                params[2] = null;
                params[3] = null;
                params[4] = documento.getTipoDocumento();
                params[5] = documento.getNumDocumento();
                params[6] = null;
                params[7] = documento.getMonto();
                params[8] = documento.getMoneda();
                params[9] = null;
                //Req. 87567 E2.1 ID 186 avilca 18/08/2020
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                //Req. 87567 E2.1 ID 186 avilca 18/08/2020
                System.out.println("tipo de documento en el type handler ORIGINAL: "+documento.getTipoDocumento());
                System.out.println("fecha en el type handler ORIGINAL: "+documento.getFecha());
                Date parsed = format.parse(documento.getFecha());
                java.sql.Date sql = new java.sql.Date(parsed.getTime());
                System.out.println("fecha en el type handler parseado: "+parsed);
                System.out.println("fecha en el type handler - getTime(): "+sql);
                params[10] = sql;//documento.getFecha();
                params[11] = null;
                params[12] = null;
                params[13] = null;
                params[14] = null;
                
                STRUCT struct = new STRUCT(structDescriptor, oracleConn, params);
                structs[contador] = struct;
                
                contador = contador + 1;
            } catch (ParseException ex) {
                Logger.getLogger(DocumentosRelacionadosTypeHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("VENTA.VVE_TYTA_DOCU_RELA", oracleConn);
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
