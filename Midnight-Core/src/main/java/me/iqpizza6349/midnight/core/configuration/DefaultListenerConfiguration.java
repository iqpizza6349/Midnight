package me.iqpizza6349.midnight.core.configuration;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.event.listener.bot.DefaultBotReadyListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * configuration class that Default Bot Ready Listener register with beans
 * @author iqpizza6349
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MidnightProperties.class)
public class DefaultListenerConfiguration {

    @Bean
    public DefaultBotReadyListener botConstructedEventListener() {
        return new DefaultBotReadyListener();
    }
}
