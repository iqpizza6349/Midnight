package me.iqpizza6349.midnight.core.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.model.message.Message;
import me.iqpizza6349.midnight.util.MessageSender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageSender implements MessageSender<Message> {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Override
    public void sendMessage(Message message, String topic) {
        try {
            kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException | ExecutionException e) {
            log.warn("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
