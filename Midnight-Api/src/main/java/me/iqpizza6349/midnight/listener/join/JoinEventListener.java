package me.iqpizza6349.midnight.listener.join;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.listener.BotEventListener;

public interface JoinEventListener extends BotEventListener {

    void onMemberJoin(MemberEvent event);

    @Override
    default void onEvent(GeneralEvent event) {
        if (event instanceof MemberEvent memberEvent) {
            onMemberJoin(memberEvent);
        }
    }
}
