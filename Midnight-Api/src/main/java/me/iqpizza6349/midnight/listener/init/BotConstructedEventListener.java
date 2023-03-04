package me.iqpizza6349.midnight.listener.init;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.BotEventListener;

public interface BotConstructedEventListener extends BotEventListener {

    void onSetup(GeneralEvent event);

    void onShutdown(CloseEvent event);

    @Override
    default void onEvent(GeneralEvent event) {
        if (event instanceof CloseEvent closeEvent) {
            onShutdown(closeEvent);
        }
        else {
            onSetup(event);
        }
    }
}
