package com.seuportfolio.financial_aggregator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Avisa ao Spring que este é um arquivo de configurações globais
public class OpenApiConfig {

    @Bean // Diz ao Spring para executar isso ao iniciar e guardar o resultado
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Financial Aggregator API")
                        .version("1.0.0")
                        .description("API REST para agregação de dados financeiros e histórico de cotações da B3. Construída com Spring Boot, OpenFeign e H2 Database."));
    }
}