package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class HelloControllerTest {
    @LocalServerPort
    private int port;
    private String baseUrl;
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        baseUrl="http://127.0.0.1:"+port;
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void index() {
        log.info("request url is: "+baseUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
        log.info(response.getBody());
        //Assertions.assertEquals(response.getBody(),"Welcome to Spring Boot!");
    }
}
