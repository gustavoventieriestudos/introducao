package io.github.fatec.config;

import io.github.fatec.service.CalcularService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalcularServiceConfig {

    @Bean
    public CalcularService calcularService() {
        return new CalcularService();
    }

}