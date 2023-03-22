package me.iqpizza6349.midnight.core.configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@RequiredArgsConstructor
@ConfigurationProperties("bot")
public class BotProperties {

    private String name;
    private String topic;
    private String groupId;
    private String kafkaBroker;
    private String destination;

}
