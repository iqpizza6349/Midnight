package me.iqpizza6349.midnight.util;

public interface MessageSender<T> {

    void sendMessage(T t, String topic);

}
