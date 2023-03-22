package me.iqpizza6349.midnight.event.listener;

import me.iqpizza6349.midnight.event.handler.EventHandler;

public abstract class AbstractEventListener implements EventListener {

    public AbstractEventListener() {
        EventHandler.addListener(this);
    }
}
