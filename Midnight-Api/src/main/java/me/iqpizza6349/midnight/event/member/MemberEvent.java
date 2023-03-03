package me.iqpizza6349.midnight.event.member;

import lombok.Getter;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.model.client.Member;

@Getter
public class MemberEvent extends GeneralEvent {

    private final Member member;

    public MemberEvent(int responseCode, Member member) {
        super(responseCode);
        this.member = member;
    }

    public MemberEvent(Member member) {
        super(200);
        this.member = member;
    }
}
