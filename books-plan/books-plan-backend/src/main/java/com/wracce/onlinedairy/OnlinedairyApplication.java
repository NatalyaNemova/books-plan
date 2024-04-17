package com.wracce.onlinedairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class OnlinedairyApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlinedairyApplication.class, args);
	}


}
