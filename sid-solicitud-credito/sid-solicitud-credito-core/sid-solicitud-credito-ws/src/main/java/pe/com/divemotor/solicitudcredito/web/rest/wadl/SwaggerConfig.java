package pe.com.divemotor.solicitudcredito.web.rest.wadl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pe.com.divemotor.generico.util.GenericoConstantes;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author phramirez
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
        List<Parameter> defaultParameters = new ArrayList<>();
        defaultParameters.add(
            new ParameterBuilder()
            .parameterType("header")
            .name(GenericoConstantes.TOKEN)
            .description("Token")
            .modelRef(new ModelRef("string"))
            .required(true)
            .build()
        );

        return new Docket(DocumentationType.SWAGGER_2)  
          .globalOperationParameters(defaultParameters)
          .select()                                  
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())               
          .build();     

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
