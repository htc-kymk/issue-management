package com.htckymk.issue_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
            @Bean
            public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new io.swagger.v3.oas.models.info.Info()
                                .title("Issue Management API Reference")
                                .version("1.0.0")
                                .description("API documentation for Issue Management")
                        );
            }

            @Bean
            public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                        .group("public")
                        .pathsToMatch("/**")
                        .packagesToScan("com.htckymk.issue_management")
                        .build();
            }
        }

