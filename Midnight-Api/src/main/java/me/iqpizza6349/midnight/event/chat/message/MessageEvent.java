package me.iqpizza6349.midnight.event.chat.message;

import me.iqpizza6349.midnight.event.chat.channel.MessageChannelEvent;
import me.iqpizza6349.midnight.event.chat.member.MemberEvent;
import me.iqpizza6349.midnight.model.MidnightAuditing;
import me.iqpizza6349.midnight.model.channel.MessageChannel;
import me.iqpizza6349.midnight.model.member.Member;
import me.iqpizza6349.midnight.model.message.Message;

public class MessageEvent extends MessageChannelEvent implements MemberEvent {

    private final Message message;
    private final Member member;

    public MessageEvent(int code, MidnightAuditing auditing, MessageChannel channel,
                        Message message, Member member) {
        super(code, auditing, channel);
        this.message = message;
        this.member = member;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public Member getMember() {
        return member;
    }
}
