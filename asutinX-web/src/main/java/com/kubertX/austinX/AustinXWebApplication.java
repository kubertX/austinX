package com.kubertX.austinX;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kubertX.austinX.common.mapper")
public class AustinXWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AustinXWebApplication.class,args);
    }
}
