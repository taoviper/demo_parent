package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-28 14:35
 */
@SpringBootApplication
@EnableEurekaClient
public class AMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(AMQApplication.class,args);
    }
}
