package me.iqpizza6349.midnight.core.configuration.construct;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(BotProperties.class)
public class BotConstructConfiguration {

    private final BotConstructedEventListener constructedEventListener;

    @PostConstruct
    private void botInit() {
        constructedEventListener.onSetup(new GeneralEvent(200) {
            @Override
            public int getResponseCode() {
                return super.getResponseCode();
            }
        });
    }

    @PreDestroy
    private void botClose() {
        constructedEventListener.onShutdown(new CloseEvent("shutdown by program closed", 200));
    }
}
