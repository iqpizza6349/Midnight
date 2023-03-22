package me.iqpizza6349.midnight.event.handler;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.listener.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventHandler {

    private static final int MAX_THREAD_POOL = 5;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    /**
     * Note : ArrayList may occur ConcurrentModificationException so using
     * CopyOnWriteArrayList for prevent Exception based on multi thread. Do not
     * use below source code. private static List<EventListener> listeners = new
     * ArrayList<EventListener>();
     */
    private static final List<EventListener> listeners = new CopyOnWriteArrayList<>();

    private static synchronized List<EventListener> getListeners() {
        return listeners;
    }

    public static synchronized void addListener(EventListener eventListener) {
        if (!getListeners().contains(eventListener)) {
            listeners.add(eventListener);
        }
    }

    public static synchronized void removeListener(EventListener eventListener) {
        if (!getListeners().contains(eventListener)) {
            listeners.remove(eventListener);
        }
    }

    public static synchronized void callEvent(final Class<?> caller, GeneralEvent event) {
        callEvent(caller, event, true);
    }

    public static synchronized void callEvent(final Class<?> caller, GeneralEvent event,
                                              boolean doAsync) {
        if (doAsync) {
            callEventByAsync(caller, event);
        }
        else {
            callEventBySync(caller, event);
        }
    }

    private static synchronized void callEventByAsync(final Class<?> caller,
                                                      final GeneralEvent event) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_POOL);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[Event occur: <{}> by <{}>]", event, caller.getName());
        }

        for (final EventListener listener : listeners) {
            executorService.execute(() -> callEvent(caller, event, listener));
        }

        executorService.shutdown();
    }


    private static synchronized void callEventBySync(final Class<?> caller,
                                                     final GeneralEvent event) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[Event occur: <{}> by <{}>]", event, caller.getName());
        }

        for (final EventListener listener : listeners) {
            callEvent(caller, event, listener);
        }
    }

    private static void callEvent(Class<?> caller, GeneralEvent event, EventListener listener) {
        if (listener.getClass().getName().equals(caller.getName())) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.info("[Event skip: <{}> by self <{}>]", event, caller.getName());
            }
        }
        else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[Event catch : <{}> by <{}>]", event, caller.getName());
            }

            listener.onEvent(event);
        }
    }
}
