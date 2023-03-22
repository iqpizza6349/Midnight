package me.iqpizza6349.midnight.event.chat.join;

import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.channel.Channel;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.member.Member;

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
