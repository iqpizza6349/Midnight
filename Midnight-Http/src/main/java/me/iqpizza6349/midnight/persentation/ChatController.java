package me.iqpizza6349.midnight.persentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.listener.join.JoinEventListener;
import me.iqpizza6349.midnight.model.client.Member;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ChatController {

    private final KafkaMessageSender sender;
    private final JoinEventListener joinEventListener;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody @Valid Message message) {
        sender.sendMessage(message);
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
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}
