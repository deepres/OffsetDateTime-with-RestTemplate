package com.example.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


/**
 * Created by Piotr Dziubecki (piotr.dziubecki@keymile.com) on 16/11/2017.
 */
@RestController
public class ExampleController {
    private final static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = { "/consume" }, method = RequestMethod.POST)
    public ResponseEntity taskConsume(@RequestBody String request) {
        logger.info(String.format("Rest template: %s", request));
        return ResponseEntity.status(HttpStatus.CREATED).headers(null).body(request);
    }
    @RequestMapping(value = { "/produce" }, method = RequestMethod.GET)
    public ExampleBeanWithTime taskProduce()
            throws JsonProcessingException {

        demoService.testTime();

        ExampleBeanWithTime exampleBeanWithTime = new ExampleBeanWithTime();

        exampleBeanWithTime.setLabel("test from controller");
        exampleBeanWithTime.setTime(OffsetDateTime.now());

        return exampleBeanWithTime;

    }

}
