package me.iqpizza6349.midnight.event.chat.join;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.event.chat.channel.ChannelEvent;
import me.iqpizza6349.midnight.event.chat.member.MemberEvent;
import me.iqpizza6349.midnight.model.MidnightAuditing;

/**
 * A abstract event class that when member(client) entrance to channel <br>
 * Well-known implement class: <br>
 * {@link MemberMessageChannelJoinEvent}
 * @author iqpizza6349
 * @since 1.0
 */
@RequiredArgsConstructor
public abstract class MemberChannelJoinEvent implements ChannelEvent, MemberEvent {

    private final int code;
    protected final MidnightAuditing auditing;
    
    @Override
    public final int getResponseCode() {
        return code;
    }

    @Override
    public final MidnightAuditing getAuditing() {
        return auditing;
    }
}
