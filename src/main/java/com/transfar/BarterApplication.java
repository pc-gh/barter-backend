package com.transfar;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.transfar.mapper")
public class BarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(BarterApplication.class,args);
    }
}
