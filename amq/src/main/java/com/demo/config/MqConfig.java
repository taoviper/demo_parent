package com.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author taoweipu
 * @date 2020-9-15 10:52
 */
@Configuration
public class MqConfig {

    @Bean
    public Queue queueOrder(){
        return new Queue("sms", true);
    }
}
