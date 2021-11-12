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

    @GetMapping("/hello/{name}")
    public String helloKafka(@PathVariable String  name){

        Employee employee = Employee.newBuilder().setFirstName(name).setLastName("Nepal").setPhoneNumber("123").build();
        //testProducer.doIt();
        testProducer.send(employee);
        return "Hello Kafka";
    }
}