package com.thekinv21.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(description = "OpenApi documentation", title = "Utility", version = "1.0"),
        security = {@SecurityRequirement(name = "bearerAuth")}
)
@Configuration
public class OpenApiConfig {

}
