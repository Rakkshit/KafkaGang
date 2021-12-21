package com.example.kafkagang.porducer;

import com.example.kafkagang.Employee;
import com.example.kafkagang.binder.TestBinder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
class TestProducerTest {

    @Autowired TestProducer testProducer;
    @Autowired TestBinder testBinder;
//    @Mock MessageChannel channel;
//
//    @Test
//    public void testMessages() {
//        testProducer.send(Employee.newBuilder().setFirstName("").setLastName("Nepal").setPhoneNumber("123").build());
//    }

}