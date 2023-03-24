package me.iqpizza6349.midnight.event.chat.member;

import me.iqpizza6349.midnight.event.chat.ChatEvent;
import me.iqpizza6349.midnight.model.member.Member;

/**
 * Event interface that expresses actions of members (users) as events <br>
 * @since 1.0
 * @author iqpizza6349
 */
public interface MemberEvent extends ChatEvent {

    /**
     * member that triggered the event
     * @return member
     */
    Member getMember();

}
