package me.iqpizza6349.midnight.core.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.BotConfig;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order
@Component
@RequiredArgsConstructor
public class DefaultConstructHandler implements BotConstructedEventListener {

    private final BotConfig botConfig;

    @Override
    public void onSetup(GeneralEvent event) {
        log.info("{} is ready to chat!", botConfig.getName());
    }

    @Override
    public void onShutdown(CloseEvent event) {
        log.info("{} ---- status: {}", event.getReason(), event.getResponseCode());
    }
}
