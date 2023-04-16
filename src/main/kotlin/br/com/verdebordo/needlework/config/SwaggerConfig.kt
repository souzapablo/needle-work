package br.com.verdebordo.needlework.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("br.com.verdebordo.needlework")
            .pathsToMatch("/api/v1/users/**", "/api/v1/suppliers/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info()
                    .title("NeedleWork API")
                    .description("Spring shop sample application")
                    .version("v1")
                    .contact(
                        Contact()
                            .name("Pablo Souza")
                            .email("pablo.osouza@outlook.com")
                            .url("https://linkedin.com/in/szpbl")
                    )
            )
    }
}