package com.xk.sign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com/xk/sign/mapper")
@EnableScheduling
@SpringBootApplication
public class SignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignApplication.class, args);
    }
}
