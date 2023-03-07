package me.iqpizza6349.midnight.core.configuration.construct;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import me.iqpizza6349.midnight.core.handler.DefaultConstructHandler;
import me.iqpizza6349.midnight.core.handler.DefaultMemberJoinHandler;
import me.iqpizza6349.midnight.core.handler.DefaultMessageHandler;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;
import me.iqpizza6349.midnight.listener.join.JoinEventListener;
import me.iqpizza6349.midnight.listener.message.MessageEventListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ConditionalOnClass({BotConstructedEventListener.class, JoinEventListener.class, MessageEventListener.class})
public class DefaultHandlerConfiguration {

    private final KafkaMessageSender messageSender;
    private final BotProperties botProperties;

    @Bean
    public BotConstructedEventListener botConstructedEventListener() {
        return new DefaultConstructHandler(botProperties);
    }

    @Bean
    public JoinEventListener joinEventListener() {
        return new DefaultMemberJoinHandler(messageSender, botProperties);
    }

    @Bean
    public MessageEventListener messageEventListener() {
        return new DefaultMessageHandler();
    }
}
