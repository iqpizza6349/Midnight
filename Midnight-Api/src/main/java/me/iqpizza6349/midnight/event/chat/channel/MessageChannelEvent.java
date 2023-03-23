package me.iqpizza6349.midnight.event.chat.channel;

import me.iqpizza6349.midnight.model.message.Message;

/**
 * An event interface that expresses that occur on the message-channel <br>
 * this interface must be have {@link Message} class <br>
 * Well-Known implements: <br>
 * {@link me.iqpizza6349.midnight.event.chat.message.MessageEvent}
 * @author iqpizza6349
 * @since 1.0
 */
public interface MessageChannelEvent extends ChannelEvent {

    /**
     * {@link Message} that occurred in message-channel
     * @return occurred message in message-channel
     */
    Message getMessage();
}
