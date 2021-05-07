package ${groupId}.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase encargada de generar la documentación Swagger para Portal SwaggerHub Telefonica.
 * @autor: COE-Arquitectura-Telefonica
 * @date: 19-10-2020
 * @version 1.0
 * @see https://springfox.github.io/springfox/
 **/
@Configuration
@EnableSwagger2
public class SpringFoxConfig    {                                    
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
		            .apis(RequestHandlerSelectors.any())
		            .paths(PathSelectors.regex("/users.*"))
		            .build();
	}
}
	

