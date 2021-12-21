package com.example.kafkagang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
public class Config {
    @Bean
    MessageChannel messageChannelOutput() {
        return new MessageChannelOutput();
    }
}
