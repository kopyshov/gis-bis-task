package com.kopyshov.renderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RenderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenderServiceApplication.class, args);
    }

}
