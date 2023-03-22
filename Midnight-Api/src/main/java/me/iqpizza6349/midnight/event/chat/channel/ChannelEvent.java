package me.iqpizza6349.midnight.event.chat.channel;

import me.iqpizza6349.midnight.event.chat.ChatEvent;
import me.iqpizza6349.midnight.model.channel.Channel;

public interface ChannelEvent extends ChatEvent {

    Channel getChannel();

}
