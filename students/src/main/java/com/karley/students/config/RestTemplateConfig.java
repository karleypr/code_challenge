package com.karley.students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración RestTemplateConfig
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Inyección del bean RestTemplate en el contexto de Spring
     *
     * @return RestTemplate
     */
    @Bean("restClient")
    public RestTemplate toRegisterRestTemplate(){
        return new RestTemplate();
    }
}
