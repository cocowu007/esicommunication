package com.esi.esicommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class EsicommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsicommunicationApplication.class, args);
	}

	@Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Posts - Comments API")
                .description("Posts - Comments API")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Posts - Comments Documentation")
                .url("http://localhost:8080/swagger-ui/4.15.5/index.html"));
    }

}
