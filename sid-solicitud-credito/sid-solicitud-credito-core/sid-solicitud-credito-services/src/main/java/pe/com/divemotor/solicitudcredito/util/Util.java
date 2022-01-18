/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.util;

import com.google.common.base.Strings;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;

/**
 *
 * @author loliveros
 */
public class Util {

    public static Map<String, Integer> determinarLimites(int nroPag, int cantidadxPag) {
        Map<String, Integer> limites = new HashMap<>();

        Integer liminf = 1;
        Integer limsup = 10;
        if (nroPag > 0 && cantidadxPag > 0) {
            liminf = (nroPag - 1) * cantidadxPag + 1;
            limsup = nroPag * cantidadxPag;
        }

        limites.put("liminf", liminf);
        limites.put("limsup", limsup);

        return limites;

    }

    public static int determinarNroPaginas(int total, int cantidadxPag) {
        int n = 0;
        int residuo = total % cantidadxPag;
        int divint = ((total - residuo) / cantidadxPag);
        n = divint;
        if (residuo > 0) {
            n++;
        }

        return n;
    }

    public static String ListToString(List<String> list) {
        String cadena = "";
        if (list != null) {
            int i = 1;
            for (String cadenax : list) {
                if (list.size() == i) {
                    cadena += cadenax;
                } else {
                    cadena += cadenax + ",";
                }
                i++;
            }
        }
        return cadena.replace("[", "").replace("]", "");
    }

    public static String ListToStringInt(List<String> list) {
        String cadena = "";
        if (list != null) {
            int i = 1;
            for (String cadenax : list) {
                if (list.size() == i) {
                    cadena += "" + cadenax + "";
                } else {
                    cadena += "" + cadenax + ",";
                }
                i++;
            }
        }
        return cadena.replace("[", "").replace("]", "");
    }

    public static String getCodigoErrorByDate() {
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String codigoError = formatter.format(new Date());

        return codigoError;
    }

    public static void setEmptyFromPairNullValue(Map parametros) {

        Iterator it = parametros.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if (pair.getValue() == null) {
                parametros.put(pair.getKey(), "");
            }

        }

    }

    public static String listInttoString(List<Integer> list) {
        String cadena = "";
        if (list != null) {
            int i = 1;
            for (Integer item : list) {
                if (list.size() == i) {
                    cadena += "" + item + "";
                } else {
                    cadena += "" + item + ",";
                }
                i++;
            }
        }
        return cadena;
    }

    public static List<Integer> listStringToInt(List<String> list) {

        List<Integer> listInteger = new ArrayList<>();
        for (String item : list) {
            listInteger.add(Integer.parseInt(item));
        }

        return listInteger;
    }

    public static String addFecha(int cantAdd) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String fecha = dateFormat.format(date); //today

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(fecha));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.add(Calendar.DATE, cantAdd);  // number of days to add
        return sdf.format(c.getTime());
    }

    public static HttpHeaders getErrorHeaders(String errorMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("estado", errorMessage);
        return headers;
    }

    public static String getParseoDetinatarios(Map parametros) {

        List<String> listCodColaborador = new ArrayList();
        String codigos = "";
        // lista correos
        if (parametros.get("codColaborador").toString().length() > 0) {

            listCodColaborador = (List<String>) parametros.get("codColaborador");
            if (listCodColaborador != null && !listCodColaborador.isEmpty() && listCodColaborador.size() > 0) {
                codigos = Util.ListToString(listCodColaborador);
            }
            parametros.put("codColaborador", codigos);
        }

        return codigos;
    }

    private static final Charset utf8charset = Charset.forName("UTF-8");
    private static final Charset iso88591charset = Charset.forName("ISO-8859-1");

    public static String toUTF8(String text) {
        if (Strings.isNullOrEmpty(text)) {
            return text;
        }

        return new String(text.getBytes(iso88591charset), utf8charset);
    }
}
