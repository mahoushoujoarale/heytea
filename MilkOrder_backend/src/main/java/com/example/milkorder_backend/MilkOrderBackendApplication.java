package com.example.milkorder_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.milkorder_backend.mapper")
@SpringBootApplication
public class MilkOrderBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilkOrderBackendApplication.class, args);
    }

}
