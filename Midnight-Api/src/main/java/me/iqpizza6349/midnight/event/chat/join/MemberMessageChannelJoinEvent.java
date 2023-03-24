package me.iqpizza6349.midnight.event.chat.join;

import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.channel.Channel;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.member.Member;

/**
 * Class that is fired when a user enters a chat channel <br>
 *
 * Please see the {@link MemberChannelJoinEvent} class
 * @author iqpizza6349
 * @since 1.0
 */
public class MemberMessageChannelJoinEvent extends MemberChannelJoinEvent {

    private final MessageChannel channel;
    private final Member member;

    public MemberMessageChannelJoinEvent(int code, MidnightAuditing auditing,
                                         MessageChannel channel, Member member) {
        super(code, auditing);
        this.channel = channel;
        this.member = member;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public Member getMember() {
        return member;
    }
}
