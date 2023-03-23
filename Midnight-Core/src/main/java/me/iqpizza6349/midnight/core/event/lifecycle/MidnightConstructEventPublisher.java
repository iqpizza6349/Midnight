package me.iqpizza6349.midnight.core.event.lifecycle;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.MidnightConfiguration;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.midnight.MidnightReadyEvent;
import me.iqpizza6349.midnight.event.handler.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MidnightConstructEventPublisher {

    private final MidnightConfiguration configuration;

    @PostConstruct
    private void midnightApplicationConstruct() {
        GeneralEvent event = new MidnightReadyEvent(200, configuration.auditing());
        EventHandler.callEvent(MidnightConstructEventPublisher.class, event, false);
    }
}
