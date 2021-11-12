package com.example.kafkagang.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestBinder {
    String channelName = "output";

    @Output(channelName)
    MessageChannel output();
}
