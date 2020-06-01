package com.example.demo.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HealthCheckController {
    private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/ping")
    public String healthCheck() {
        logger.info("/ping request received");

        return "PONG";
    }
    
    @RequestMapping(path="/{id}")
    public String getMessage(@PathVariable("id") String id) {
        
       logger.info("request received in IOT backend for user id"+id);
        
       switch(id){
           case "1":
               return "Ashish";
               
           case "2":
               return "Prince";
               
       }
        
        return "invalid user id";
    }
}
