package com.zhan.mp_optimisticlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zhan.mp_optimisticlock.mapper")
public class MpOptimisticlockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpOptimisticlockApplication.class, args);
    }

}
