package me.iqpizza6349.midnight.persentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.constraints.KafkaConstraints;
import me.iqpizza6349.midnight.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ChatController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody @Valid Message message) {
        try {
            // sending the message to kafka topic queue
            kafkaTemplate.send(KafkaConstraints.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            log.warn("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // ---- WebSocket API ----
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadCastGroupMessage(@Payload Message message) {
        // sending this message to all the subscribers
        return message;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/group")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // add user in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}
