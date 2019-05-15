package org.kd.springboot.springrest.demo.server.config;

import org.kd.springboot.springrest.demo.client.CommonUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${server.port}")
    private String port;

    @Bean
    public RestTemplate countryRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.rootUri("http://localhost:8083").build();
    }

    @Bean
    public CommonUtility commonUtility(){
        return new CommonUtility();
    }

    public String getPort() {
        return port;
    }
}
