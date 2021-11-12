package com.example.kafkagang.binder;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestBinder {
    String channelName = "kripa";

    @Output(channelName)
    MessageChannel output();
}
