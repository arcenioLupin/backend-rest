/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.divemotor.solicitudcredito.web.rest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.com.divemotor.solicitudcredito.util.Constantes;
import pe.com.divemotor.resource.service.ValidationService;

/**
 *
 * @author phramirez
 */
@Component(value = "tokenValidationFilter")
public class TokenValidationFilter implements javax.servlet.Filter {

    private static final Logger LOGGER = Logger.getLogger(TokenValidationFilter.class.getName());
    private static final String AUTHENTICATION_TOKEN_HEADER = "token";
    
    @Autowired
    private ValidationService validationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filter) throws IOException, ServletException {
                
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletRequest req = (HttpServletRequest) request;
            boolean swaggerRequest = req.getRequestURI().contains("swagger")
                    || req.getRequestURI().contains("configuration")
                    || req.getRequestURI().contains("api-docs")
                    || req.getRequestURI().contains("sid-generico/configuracion/formatoListar")
                    || req.getRequestURI().contains("sid-ficha-venta/autorizacion-excepcional/validar-usuario")
                    || req.getRequestURI().contains("sid-ficha-venta/autorizacion-excepcional/solicitudes")
                    || req.getRequestURI().contains("sid-ficha-venta/autorizacion-excepcional/solicitudes/autorizar"                    
                    );

            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "content-type, accept, codidusuario, codusuario, token, idusuario, indpaginado, nropag, cantidadxpag, indinactivo, numeropagina, registrospagina, numpag, cantiregpag, codareavta, tipoAccion, buscar");
            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, DELETE, PUT, POST");
            
            if (swaggerRequest || "OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
                filter.doFilter(request, response);
            } else {
                String authCredentials = httpServletRequest
                        .getHeader(AUTHENTICATION_TOKEN_HEADER);
                String username = validationService.getUsernameFromToken(authCredentials);
                if (username != null) {
                    try {
                        if (validationService.validateToken(authCredentials, username)) {
                            filter.doFilter(request, response);
                        } else {
                            statusResponse(response, HttpServletResponse.SC_UNAUTHORIZED);
                        }
                    } catch (Exception ex) {
                        String mensajeError = Constantes.ID_ERROR_APP + pe.com.divemotor.solicitudcredito.util.Util.getCodigoErrorByDate();
                        LOGGER.error(mensajeError + "\n" + ex.getMessage(), ex);
                        statusResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    }
                } else {
                    statusResponse(response, HttpServletResponse.SC_UNAUTHORIZED);
                }                    
            }
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void destroy() {

    }
    
    private HttpServletResponse statusResponse(ServletResponse response, int status) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(status);        
        return httpServletResponse;
    }    
}
