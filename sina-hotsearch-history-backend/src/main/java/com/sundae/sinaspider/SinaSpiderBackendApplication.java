package com.sundae.sinaspider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sundae.sinaspide.dao.mapper")
public class SinaSpiderBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinaSpiderBackendApplication.class, args);
    }

}
