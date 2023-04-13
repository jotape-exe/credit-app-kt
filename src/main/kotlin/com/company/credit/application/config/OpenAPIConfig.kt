package com.company.credit.application.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.info.Info;


@Configuration
@OpenAPIDefinition
class OpenAPIConfig {
    @Bean
    fun baseOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Credit System API").version("1.0.0")
                    .description("Application to control a credit system")
            )
    }
}