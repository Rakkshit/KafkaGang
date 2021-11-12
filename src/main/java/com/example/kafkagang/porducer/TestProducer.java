package com.example.kafkagang.porducer;

import com.example.kafkagang.Employee;
import com.example.kafkagang.binder.TestBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({TestBinder.class})
public class TestProducer {

    @Autowired
    private TestBinder testBinder;

//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(Employee myArg){
        try {
            //kafkaTemplate.send("Shanta",myArg);
            testBinder.output().send(MessageBuilder.withPayload(myArg).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
