package me.iqpizza6349.midnight.core.configuration;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Midnight Configuration class about MidnightAuditing to make single-ton
 * @author iqpizza6349
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class MidnightConfiguration {

    private final MidnightProperties properties;

    @Bean @ConditionalOnMissingBean
    public MidnightAuditing auditing() {
        return new MidnightAuditing(properties.getName());
    }

}
