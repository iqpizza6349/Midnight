package me.iqpizza6349.midnight.event.midnight;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.constraints.MidnightStatus;
import me.iqpizza6349.midnight.model.MidnightAuditing;

/**
 * Event class used when Midnight framework is ready to end or end operation <br>
 * {@link #getStatus()} must returns {@link MidnightStatus#SHUTDOWN}
 * @author iqpizza6349
 * @version 1.0
 */
@RequiredArgsConstructor
public class MidnightShutdownEvent implements MidnightEvent {

    private final int code;
    private MidnightAuditing auditing;

    @Override
    public int getResponseCode() {
        return code;
    }

    @Override
    public MidnightAuditing getAuditing() {
        return auditing;
    }

    @Override
    public MidnightStatus getStatus() {
        return MidnightStatus.SHUTDOWN;
    }
}
