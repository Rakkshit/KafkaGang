package com.example.kafkagang;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class MessageChannelOutput implements MessageChannel {
    @Override
    public boolean send(Message<?> message) {
        return send(message,INDEFINITE_TIMEOUT);
    }

    @Override
    public boolean send(Message<?> message, long timeout) {
        System.out.println("here123");
        return true;
    }
}
