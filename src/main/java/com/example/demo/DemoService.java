package com.example.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;


/**
 * Created by Piotr Dziubecki (piotr.dziubecki@keymile.com) on 16/11/2017.
 */
@Service
public class DemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void testTime()
            throws JsonProcessingException {

        ExampleBeanWithTime exampleBeanWithTime = new ExampleBeanWithTime();
        exampleBeanWithTime.setLabel("test from controller");
        exampleBeanWithTime.setTime(OffsetDateTime.now());
        HttpEntity<ExampleBeanWithTime> entity = new HttpEntity<>(exampleBeanWithTime,new HttpHeaders());
        ResponseEntity<String> answer = restTemplate.exchange("http://localhost:8080/consume", HttpMethod.POST, entity, String.class);

        logger.info(String.format("Object mapper:%s", objectMapper.writeValueAsString(exampleBeanWithTime)));



    }
}
