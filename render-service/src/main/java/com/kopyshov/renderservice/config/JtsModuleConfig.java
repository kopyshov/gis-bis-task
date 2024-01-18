package com.kopyshov.renderservice.config;


import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JtsModuleConfig {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
