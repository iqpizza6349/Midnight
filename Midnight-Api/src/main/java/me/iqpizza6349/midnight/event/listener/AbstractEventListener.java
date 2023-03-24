package me.iqpizza6349.midnight.event.listener;

import me.iqpizza6349.midnight.event.handler.EventHandler;

/**
 * The Abstract class only for automatically registered in EventHandler <br>
 * Please see the {@link EventHandler}
 * @author iqpizza6349
 * @since 1.0
 */
public abstract class AbstractEventListener implements EventListener {

    public AbstractEventListener() {
        EventHandler.addListener(this);
    }
}
