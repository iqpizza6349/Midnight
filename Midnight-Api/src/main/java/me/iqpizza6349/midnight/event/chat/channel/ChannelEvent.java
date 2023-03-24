package me.iqpizza6349.midnight.event.chat.channel;

import me.iqpizza6349.midnight.event.chat.ChatEvent;
import me.iqpizza6349.midnight.model.channel.Channel;

/**
 * An event interface that expresses events that occur on the channel <br>
 * @since 1.0
 * @author iqpizza6349
 */
public interface ChannelEvent extends ChatEvent {

    /**
     * returns where the event occurred
     * @return channel which occurred events
     */
    Channel getChannel();

}
