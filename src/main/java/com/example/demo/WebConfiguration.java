package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Piotr Dziubecki (piotr.dziubecki@keymile.com) on 16/11/2017.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RestTemplate getRestTemplate() { return new RestTemplate(); }

}
