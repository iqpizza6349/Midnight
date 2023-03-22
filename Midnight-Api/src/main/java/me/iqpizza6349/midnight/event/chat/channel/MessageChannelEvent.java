package me.iqpizza6349.midnight.event.chat.channel;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.channel.Channel;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.message.Message;

@RequiredArgsConstructor
public abstract class MessageChannelEvent implements ChannelEvent {

    private final int code;
    protected final MidnightAuditing auditing;
    protected final MessageChannel channel;

    @Override
    public final int getResponseCode() {
        return code;
    }

    @Override
    public final MidnightAuditing getAuditing() {
        return auditing;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    public abstract Message getMessage();
}
