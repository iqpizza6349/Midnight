package me.iqpizza6349.midnight.core.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
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
