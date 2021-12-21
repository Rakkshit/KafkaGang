package com.example.kafkagang;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableSchemaRegistryClient
public class KafkaGangApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaGangApplication.class, args);
    }


    @ServiceActivator(inputChannel = "output.errors")
    void meta(Message<Employee> sent) {
        System.out.println("Sent: " + sent.getHeaders().get(KafkaHeaders.RECORD_METADATA, RecordMetadata.class));
    }

}
