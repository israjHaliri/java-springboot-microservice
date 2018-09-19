package com.haliri.israj.appaccount.message;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic}",
            groupId = "${kafka.group}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
