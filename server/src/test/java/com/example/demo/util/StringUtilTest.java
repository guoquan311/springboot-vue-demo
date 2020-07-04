package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StringUtilTest {
    @Test
    public void testToUpperCase() {
        log.info("testToUpperCase");
        String str = "aaaAAA";
        String uppercase = str.toUpperCase();
        Assertions.assertEquals(uppercase, StringUtil.toUpperCase(str));
    }

    @Test
    public void testToLowerCase() {
        log.info("testToLowerCase");
        String str = "aaaAAA";
        String uppercase = str.toLowerCase();
        Assertions.assertEquals(uppercase, StringUtil.toLowerCase(str));
    }
}
