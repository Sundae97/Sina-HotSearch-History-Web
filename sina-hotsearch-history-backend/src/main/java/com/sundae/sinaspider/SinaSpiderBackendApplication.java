package com.sundae.sinaspider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.sundae.sinaspider"})
public class SinaSpiderBackendApplication {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SinaSpiderBackendApplication.class, args);
    }

}
