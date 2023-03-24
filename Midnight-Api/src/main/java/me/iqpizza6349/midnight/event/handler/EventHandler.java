package me.iqpizza6349.midnight.event.handler;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.listener.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is register {@link EventListener} and handle(such as 'publish',
 * and 'subscribe') events. If you publish events, you can select with
 * two options. 'synchronous' or 'asynchronous' <br>
 * which you publish with 'synchronous', use below source code.
 * <pre>
 *     {@code EventListener.callEvent(caller, generalEvent, false);}
 * </pre>
 * if you publish with 'asynchronous', use below source code.
 * <pre>
 *     {@code EventListener.callEvent(caller, generalEvent, true);}
 * </pre>
 * or
 * <pre>
 *     {@code EventListener.callEvent(caller, generalEvent);}
 * </pre>
 * 'doAsync' arguments default value is true.
 *
 * @author iqpizza6349
 * @since 1.0
 */
public final class EventHandler {

    /**
     * thread pool that use in asynchronous event-publish
     */
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

    /**
     * add event listener register in listener container
     * if listener object is already in container do nothing
     * @param eventListener register to listener container
     */
    public static synchronized void addListener(EventListener eventListener) {
        if (!getListeners().contains(eventListener)) {
            listeners.add(eventListener);
        }
    }

    /**
     * remove event listener in listener container
     * if listener is not registered in container, do nothing
     * @param eventListener remove to listener container
     */
    public static synchronized void removeListener(EventListener eventListener) {
        if (!getListeners().contains(eventListener)) {
            listeners.remove(eventListener);
        }
    }

    /**
     * call(publish) event with 'asynchronous'
     * @param caller which class call, also used by trace
     * @param event publish to each listeners(subscribers)
     */
    public static synchronized void callEvent(final Class<?> caller, GeneralEvent event) {
        callEvent(caller, event, true);
    }

    /**
     * call(publish) event with 'synchronous' or 'asynchronous'
     * @param caller which class call, also used by trace
     * @param event publish to each listeners(subscribers)
     * @param doAsync publish with async, if value is false publish with sync
     */
    public static synchronized void callEvent(final Class<?> caller, GeneralEvent event,
                                              boolean doAsync) {
        if (doAsync) {
            callEventByAsync(caller, event);
        }
        else {
            callEventBySync(caller, event);
        }
    }

    /**
     * call(publish) event with async the default thread pool is 5
     * @param caller which class called
     * @param event publish to each listeners(subscribers)
     */
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

    /**
     * call(publish) event with sync
     * @param caller which class called
     * @param event publish to each listeners(subscribers)
     */
    private static synchronized void callEventBySync(final Class<?> caller,
                                                     final GeneralEvent event) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[Event occur: <{}> by <{}>]", event, caller.getName());
        }

        for (final EventListener listener : listeners) {
            callEvent(caller, event, listener);
        }
    }

    /**
     * publish event to listeners, but do not publish to selves(caller cannot publish to self)
     * @param caller which class called
     * @param event publish to each listeners(subscribers)
     * @param listener publish all listeners except for selves
     */
    private static void callEvent(Class<?> caller, GeneralEvent event, EventListener listener) {
        if (listener.getClass().getName().equals(caller.getName())) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[Event skip: <{}> by self <{}>]", event, caller.getName());
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
