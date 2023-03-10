package me.iqpizza6349.midnight.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.event.message.MessageEvent;
import me.iqpizza6349.midnight.listener.join.JoinEventListener;
import me.iqpizza6349.midnight.listener.message.MessageEventListener;
import me.iqpizza6349.midnight.model.client.Member;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ChatController {

    private final KafkaMessageSender sender;
    private final JoinEventListener joinEventListener;
    private final MessageEventListener messageEventListener;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody @Valid Message message) {
        sender.sendMessage(message);
        messageEventListener.onMessageReceive(new MessageEvent(message));
    }

    @PostMapping(value = "/api/join", consumes = "application/json", produces = "application/json")
    public void joinUser(@RequestBody @Valid Message message) {
        joinEventListener.onMemberJoin(new MemberEvent(new Member(message.getSender())));
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
        Objects.requireNonNull(headerAccessor.getSessionAttributes())
                .put("username", message.getSender());
        return message;
    }
}
