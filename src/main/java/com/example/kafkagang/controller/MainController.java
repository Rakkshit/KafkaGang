package com.example.kafkagang.controller;

import com.example.kafkagang.Employee;
import com.example.kafkagang.porducer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController{
    @Autowired
    TestProducer testProducer;

    @GetMapping("/hello/{msg}")
    public String helloKafka(@PathVariable String msg){

        Employee employee = Employee.newBuilder().setFirstName("Kripa").setLastName("Nepal").setAge(2).setPhoneNumber("123").build();

        testProducer.send(employee);
        return "Hello Kafka";
    }
}