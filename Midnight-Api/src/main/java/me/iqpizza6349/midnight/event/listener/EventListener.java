package me.iqpizza6349.midnight.event.listener;

import me.iqpizza6349.midnight.event.GeneralEvent;

/**
 * Handler interface that defines the behavior of receiving and processing
 * events in the Midnight Framework <br>
 * {@link me.iqpizza6349.midnight.event.handler.EventHandler} allows you
 * to handle events asynchronously and conveniently.
 * <pre>
 *     {@code EventHandler.addListener(EventListener);}
 * </pre>
 *
 * If it is annoying to set up one by one, it is recommended to inherit
 * the next abstract class. {@link AbstractEventListener}
 * The Constructor is automatically registered in EventHandler as soon as
 * it is called.
 *
 * @author iqpizza6349
 * @since 1.0
 * @see AbstractEventListener
 */
public interface EventListener {

    /**
     * 발생하는 모든 이벤트를 받고 처리함
     * @param event 최상위 이벤트
     */
    void onEvent(GeneralEvent event);

}
