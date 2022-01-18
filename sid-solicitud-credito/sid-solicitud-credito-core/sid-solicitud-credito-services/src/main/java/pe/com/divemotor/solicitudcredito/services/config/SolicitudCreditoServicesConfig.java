package pe.com.divemotor.solicitudcredito.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 *
 * @author phramirez
 */
@Configuration
public class SolicitudCreditoServicesConfig {
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasenames("file:/u01/jboss/jboss-as-7.1.1.Final/standalone/properties/sid-solicitud-credito/config");
        return source;
    }
    
}
