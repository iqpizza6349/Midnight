package me.iqpizza6349.midnight.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.MidnightProperties;
import me.iqpizza6349.midnight.core.configuration.MidnightConfiguration;
import me.iqpizza6349.midnight.event.handler.EventHandler;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.chat.join.MemberMessageChannelJoinEvent;
import me.iqpizza6349.midnight.event.chat.message.MessageEvent;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.member.Member;
import me.iqpizza6349.midnight.model.message.Message;
import me.iqpizza6349.midnight.util.MessageSender;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Default chat controller class that send and receive messages <br>
 * also get several events from clients <br>
 * In Midnight Framework, {@link RestController} is use for event publisher
 * that confirm from client
 * @author iqpizza6349
 * @since 1.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ChatController {

    private final MessageSender<Message> sender;
    private final MidnightProperties properties;
    private final MidnightConfiguration configuration;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody @Valid Message message) {
        sender.sendMessage(message, properties.getTopic());
        MessageChannel channel = new MessageChannel(message.getSender(),
                properties.getTopic(), sender);
        GeneralEvent event = new MessageEvent(200, configuration.auditing(), channel,
                message, new Member(message.getSender()));
        EventHandler.callEvent(ChatController.class, event);
    }

    @PostMapping(value = "/api/join", consumes = "application/json", produces = "application/json")
    public void joinUser(@RequestBody @Valid Message message) {
        MessageChannel channel = new MessageChannel(message.getSender(),
                properties.getTopic(), sender);
        GeneralEvent event = new MemberMessageChannelJoinEvent(200, configuration.auditing(), channel,
                new Member(message.getSender()));
        EventHandler.callEvent(ChatController.class, event);
    }

    // ---- WebSocket API ----
    @MessageMapping("/sendMessage")
    @SendTo("#{'${midnight.group-id}'}")
    public Message broadCastGroupMessage(@Payload Message message) {
        // sending this message to all the subscribers
        return message;
    }

    @MessageMapping("/newUser")
    @SendTo("#{'${midnight.group-id}'}")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // add user in web socket session
        Objects.requireNonNull(headerAccessor.getSessionAttributes())
                .put("username", message.getSender());
        return message;
    }
}
