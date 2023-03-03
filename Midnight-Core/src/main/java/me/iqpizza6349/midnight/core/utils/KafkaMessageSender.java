package me.iqpizza6349.midnight.core.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.constraints.kafka.KafkaConstraints;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageSender {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message) {
        try {
            // sending the message to kafka topic queue
            kafkaTemplate.send(KafkaConstraints.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            log.warn("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
