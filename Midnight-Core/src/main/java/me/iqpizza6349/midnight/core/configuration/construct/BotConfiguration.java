package me.iqpizza6349.midnight.core.configuration.construct;

import me.iqpizza6349.midnight.core.configuration.BotProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public BotProperties botProperties() {
        return new BotProperties();
    }
}
