package me.iqpizza6349.midnight.core.configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties("bot")
public class BotConfig {

    private String name;
    private String token;

}
