package com.demo.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakeApplication.class,args);
    }
}
