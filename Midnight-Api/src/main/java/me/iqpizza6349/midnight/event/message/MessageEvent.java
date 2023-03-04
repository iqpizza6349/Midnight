package me.iqpizza6349.midnight.event.message;

import lombok.Getter;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.model.client.Member;
import me.iqpizza6349.midnight.model.message.Message;

/**
 * 메시지를 수신받을 때 발생하는 이벤트
 */
@Getter
public class MessageEvent extends MemberEvent {

    private final Message message;

    public MessageEvent(int responseCode, Message message) {
        super(responseCode, new Member(message.getSender()));
        this.message = message;
    }

    public MessageEvent(Message message) {
        super(200, new Member(message.getSender()));
        this.message = message;
    }
}
