package com.didem.stonescissorspaper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI gameMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Game Controller")
                        .description("Basic Control Endpoints")
                        .version("1.0"));
    }
}
