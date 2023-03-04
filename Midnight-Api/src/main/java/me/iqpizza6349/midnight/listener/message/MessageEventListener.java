package me.iqpizza6349.midnight.listener.message;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.message.MessageEvent;
import me.iqpizza6349.midnight.listener.BotEventListener;

public interface MessageEventListener extends BotEventListener {

    void onMessageReceive(MessageEvent event);

    @Override
    default void onEvent(GeneralEvent event) {
        if (event instanceof MessageEvent messageEvent) {
            onMessageReceive(messageEvent);
        }
    }
}
