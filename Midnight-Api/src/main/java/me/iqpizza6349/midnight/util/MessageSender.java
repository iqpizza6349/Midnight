package me.iqpizza6349.midnight.util;

/**
 * MessageSender interface which is low-module that have to implements.
 * send Object(alias Message) to topic, and send
 * @param <T> Object type to send
 * @author iqpizza6349
 * @version 1.0
 */
public interface MessageSender<T> {

    /**
     * send object to topic
     * @param t object to send
     * @param topic where to send
     */
    void sendMessage(T t, String topic);

}
