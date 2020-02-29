package com.sundae.sinaspider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication(scanBasePackages = {"com.sundae.sinaspider"})
@MapperScan("com.sundae.sinaspider.dao")
public class SinaSpiderBackendApplication {

    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            System.out.println(simpleDateFormat.parse("2020-02-22 17:07:00").getTime());;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SinaSpiderBackendApplication.class, args);
    }

}
