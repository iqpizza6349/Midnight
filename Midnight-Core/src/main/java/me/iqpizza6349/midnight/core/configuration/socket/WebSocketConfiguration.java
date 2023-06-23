package me.iqpizza6349.midnight.core.configuration.socket;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.MidnightProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Setting Stomp with Spring SockJS and configure kafka broker
 * @author iqpizza6349
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final MidnightProperties properties;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // chat client will use this to connect to the server
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        final int lastIndex = properties.getDestination().lastIndexOf("/");
        final String prefix = properties.getDestination().substring(0, lastIndex);
        registry.enableSimpleBroker(prefix);
    }
}
