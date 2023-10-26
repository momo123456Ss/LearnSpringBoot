package com.hht.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Environment env;

    @Test
    void contextLoads() {
    }

   
}
