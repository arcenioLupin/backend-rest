package pe.com.divemotor.solicitudcredito.util;

public class Constantes {

    public static final String VACIO = "";
    public static final String ID_ERROR_APP = "SC";
    public static final int ESTADO_TRAMA_OK = 1;
    public static final int ESTADO_TRAMA_OPERACION_EXISTE = 2;
    public static final int ESTADO_TRAMA_PLAZO_VENCIDO = 2;
    public static final int ESTADO_TRAMA_ERROR_PROCEDURE = -1;
    public static final int ESTADO_TRAMA_ERROR_NEGOCIO = 0;
    public static final String RESPUESTA_ENVIO_CORREO_OK = "Se envió el correo exitosamente a los destinatarios";
    public static final String RESPUESTA_ENVIO_CORREO_NO_OK = "Hubo un error al enviar correo a los destinatarios";
    public static final String RESPUESTA_RATIO_GARA_OK = "Porcentaje Ratio de garantía es mayor a 1";
    public static final String RESPUESTA_RATIO_GARA_FAIL = "Porcentaje Ratio de garantía es menor a 1";

    // CODIGOS DE REFERENCIA DE PROCESO        
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_HFDV = "HF";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_ADJUNT = "AJ";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_AEQUIP = "EA";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_SFACTU = "SF";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_NLAFIT = "NL";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_SESTADO = "SE";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_BONOS = "BO";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_APROBACION_BONO = "AV";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_AUTORIZACION_FICHA_VENTA = "AF";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_EVENTO_SOLICITUD_CREDITO = "SC";
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_CAMBIO_TASA_SEGURO = "TS";
    // inicio Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    public static final String COD_PLANTILLA_REFERENCIA_PROCESO_EVENTOS_NOTARIA_REGISTRO = "ENR";
    // fin Req. 87567 E2.3 ID334 EBARBOZA 21/01/2020
    //NUMERO DE REGISTRO RELACIONADO
    public static final String TIPO_REGI_RELA = "02";
    public static final String COD_CORREO_FROM = "apps@divemotor.com.pe";
    
    public static final String COD_SOCIEDAD_DIVEIMPORT_SAP = "3000";
    public static final String COD_SOCIEDAD_DIVECENTER_SAP = "3100";
    public static final String COD_SOCIEDAD_CIA_DIVEIMPORT = "06";
    public static final String COD_SOCIEDAD_CIA_DIVECENTER = "09";
    public static final String STATUS_VIGENTE = "Vigente";
    public static final String STATUS_CERRADO = "Cerrado";
    
    public static final String URL_WS_SAP_MOVIMIENTOS_CLI = "sap.movimientos.cliente.ws.url";
    public static final String URL_WS_SENTINEL = "sentinel.ws.url";
    
    public static final String TIPO_DOC_DNI = "001";
    public static final String TIPO_DOC_RUC = "002";
    public static final String TIPO_DOC_CE = "003";
    
    public static final String TIPO_CRED_RDEUD = "TC01";
    public static final String TIPO_CRED_RDLEA = "TC02";
    public static final String TIPO_CRED_RDMUT = "TC03";
    public static final String TIPO_CRED_RDREF = "TC07";
    public static final String TIPO_CRED_FACT_CREDITO = "TC04";
    
    
    
    
}
