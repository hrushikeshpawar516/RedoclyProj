package com.nt;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@SecurityScheme(
	    name = "bearerAuth",
	    description = "JWT Bearer token authentication",
	    scheme = "bearer",
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    in = SecuritySchemeIn.HEADER
	)
public class InfosysPocProjectUsingRedoclyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfosysPocProjectUsingRedoclyApplication.class, args);
	}

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("My API")
	                .version("1.0.0")
	                .description("An imaginary, but delightful Museum API for interacting with museum services and information. Built with love by Redocly.")
	                .contact(new Contact().email("hrushikeshpawar@gmail.com")
	                		.name("E-mail").url("http://google.com"))
	                .license(new License().name("License").url("https://opensource.org/license/mit"))
	                .extensions(Map.of(
	                    "x-logo", Map.of(
	                        "url", "/images/DSC_9989.png",
	                        "backgroundColor", "#fff"
	                    )
	                ))
	            )
	            ;
	    }

	   
}
