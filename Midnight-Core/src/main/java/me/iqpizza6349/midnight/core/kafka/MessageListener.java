package me.iqpizza6349.midnight.core.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(
            topics = "#{'${bot.topic}'}",
            groupId = "#{'${bot.group-id}'}"
    )
    public void listen(Message message) {
        log.info("sending via kafka listener...");
        messagingTemplate.convertAndSend("/topic/group", message);
    }
}
