package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Permite requisições de qualquer origem
        config.addAllowedOrigin("*");
        
        // Permite os métodos HTTP: GET, POST, PUT, DELETE, etc.
        config.addAllowedMethod("*");
        
        // Permite todos os headers na requisição
        config.addAllowedHeader("*");
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
} 