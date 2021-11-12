package com.example.kafkagang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@SpringBootApplication
@EnableSchemaRegistryClient
public class KafkaGangApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaGangApplication.class, args);
    }

}
