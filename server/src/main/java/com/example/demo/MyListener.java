package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class MyListener implements ApplicationListener {
    private  final Logger logger = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info("onApplicationEvent  "+applicationEvent);
    }
}
