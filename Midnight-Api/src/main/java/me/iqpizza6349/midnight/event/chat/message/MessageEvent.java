package me.iqpizza6349.midnight.event.chat.message;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.event.chat.channel.MessageChannelEvent;
import me.iqpizza6349.midnight.event.chat.member.MemberEvent;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.channel.Channel;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.member.Member;
import me.iqpizza6349.midnight.model.message.Message;

/**
 * A event class that handle events that occur on message channels of
 * messages<br>
 *
 * Please see {@link MemberEvent}, {@link MessageChannelEvent} for when events are
 * occur <br>
 * @since 1.0
 * @author iqpizza6349
 */
@RequiredArgsConstructor
public class MessageEvent implements MemberEvent, MessageChannelEvent {

    private final int code;

    private final MidnightAuditing auditing;

    private final MessageChannel channel;

    private final Message message;
    private final Member member;

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public Member getMember() {
        return member;
    }

    @Override
    public int getResponseCode() {
        return code;
    }

    @Override
    public MidnightAuditing getAuditing() {
        return auditing;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }
}
