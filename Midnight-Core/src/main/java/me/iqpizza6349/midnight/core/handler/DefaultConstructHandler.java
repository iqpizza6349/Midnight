package me.iqpizza6349.midnight.core.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;

@Slf4j
@RequiredArgsConstructor
public class DefaultConstructHandler implements BotConstructedEventListener {

    private final BotProperties botProperties;

    @Override
    public void onSetup(GeneralEvent event) {
        log.info("{} is ready to chat!", botProperties.getName());
    }

    @Override
    public void onShutdown(CloseEvent event) {
        log.info("{} ---- status: {}", event.getReason(), event.getResponseCode());
    }
}
