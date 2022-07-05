package com.xiangchi.xiangchiproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("**/mysql")
public class XiangchiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiangchiProjectApplication.class, args);
    }

}
