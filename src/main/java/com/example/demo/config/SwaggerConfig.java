// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 // You need to change the port as per your server
//                 .servers(List.of(
//                         new Server().url("https://9184.pro604cr.amypo.ai/")
//                 ));
//         }
// }


package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        
        // 1. Define the Security Scheme (Bearer JWT)
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                // 2. Keep your existing Server URL configuration
                .servers(List.of(
                        new Server().url("https://9184.pro604cr.amypo.ai/")
                ))
                // 3. Add the Security Components from your reference
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerAuth))
                // 4. Add the Security Requirement so the Lock icon appears
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth"));
    }
}