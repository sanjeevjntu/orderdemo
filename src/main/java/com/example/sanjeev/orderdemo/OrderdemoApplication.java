package com.example.sanjeev.orderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaAuditing
public class OrderdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderdemoApplication.class, args);
    }
}
