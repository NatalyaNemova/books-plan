package com.wracce.onlinedairy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins (List.of("http://localhost:4200"));
//        configuration.setAllowedMethods (Arrays.asList("PUT","GET", "POST", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders (Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization")); configuration.setAllowCredentials (true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
