package com.example.demo.controller;

import com.example.demo.beans.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
@Slf4j
public class HelloController {

    @Autowired
    private Author author;

    @RequestMapping("/index1")
    public String sayHello(){
        return "index1";
    }

    @RequestMapping("/index")
    public String sayHello1(){
        log.info("My name is "+author.getName() + ". I am "+ author.getAge() +" year old.");
        return "index";
    }

    @RequestMapping("/button-click")
    public void gotoIndex1(){

    }
}
