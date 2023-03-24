package me.iqpizza6349.midnight.core.configuration;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.message.Message;
import me.iqpizza6349.midnight.util.MessageSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Midnight Configuration class about MidnightAuditing to make single-ton
 * @author iqpizza6349
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MidnightProperties.class)
public class MidnightConfiguration {

    private final MidnightProperties properties;
    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Bean @ConditionalOnMissingBean
    public MidnightAuditing auditing() {
        return new MidnightAuditing(properties.getName());
    }

    @Bean @ConditionalOnMissingBean
    public MessageSender<Message> messageSender() {
        return new KafkaMessageSender(kafkaTemplate);
    }

}
