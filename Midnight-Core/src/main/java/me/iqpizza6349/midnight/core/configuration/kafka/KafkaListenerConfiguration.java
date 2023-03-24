package me.iqpizza6349.midnight.core.configuration.kafka;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.MidnightProperties;
import me.iqpizza6349.midnight.model.message.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class that set kafka configuration with beans
 * such as 'consumer', 'listener-container'
 * @author iqpizza6349
 * @since 1.0
 */
@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaListenerConfiguration {

    private final MidnightProperties properties;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Message> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean @ConditionalOnMissingBean
    public ConsumerFactory<String, Message> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), new StringDeserializer(), new JsonDeserializer<>(Message.class));
    }

    @Bean
    public Map<String, Object> consumerConfigurations() {
        System.out.println(properties);
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getKafkaBroker());
        configurations.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getGroupId());
        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        return configurations;
    }
}
