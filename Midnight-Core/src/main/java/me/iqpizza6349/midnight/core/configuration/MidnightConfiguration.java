package me.iqpizza6349.midnight.core.configuration;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MidnightConfiguration {

    private final BotProperties properties;

    @Bean
    public MidnightAuditing auditing() {
        return new MidnightAuditing(properties.getName());
    }

}
