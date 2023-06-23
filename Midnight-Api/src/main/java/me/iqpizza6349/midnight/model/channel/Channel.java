package me.iqpizza6349.midnight.model.channel;

import me.iqpizza6349.midnight.model.message.Message;

/**
 * Interface for defining multiple channels
 * @author iqpizza6349
 * @since 1.0
 */
public interface Channel {

    /**
     * channel's destination to send and receive
     * @return channel's specific destination
     */
    String getDestination();

    /**
     * channel's topic that connect to
     * @return channel's topic
     */
    String getTopic();

    /**
     * send message to topic
     * @param text message to send
     */
    void sendMessage(String text);

    /**
     * send message to topic in framework client (not a normal way)
     * @param message message to send
     */
    void sendMessage(Message message);

    /**
     * returns who send message
     * @return sender
     */
    String getSender();

}
