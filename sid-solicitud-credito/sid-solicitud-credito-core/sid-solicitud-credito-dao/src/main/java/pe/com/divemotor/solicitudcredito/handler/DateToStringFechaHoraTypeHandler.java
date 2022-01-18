/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 *
 * @author rcamarena
 */
public class DateToStringFechaHoraTypeHandler implements TypeHandler<String>{
    
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String dateString = rs.getString(columnName);
        /*try {
            if(StringUtils.isNotBlank(dateString)
                    || StringUtils.isNotEmpty(dateString)){
                return Utilitario.getDateToString(Utilitario.getStringToDate(dateString));
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }*/
        return dateString;
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
