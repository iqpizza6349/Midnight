package me.iqpizza6349.midnight.event.chat.member;

import me.iqpizza6349.midnight.event.chat.ChatEvent;
import me.iqpizza6349.midnight.model.member.Member;

public interface MemberEvent extends ChatEvent {

    Member getMember();

}
