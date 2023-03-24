package me.iqpizza6349.midnight.event.midnight;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.constraints.MidnightStatus;
import me.iqpizza6349.midnight.model.MidnightAuditing;

/**
 * Event class used when Midnight framework is ready or completed <br>
 * {@link #getStatus()} must returns {@link MidnightStatus#READY}
 * @author iqpizza6349
 * @version 1.0
 */
@RequiredArgsConstructor
public class MidnightReadyEvent implements MidnightEvent {

    private final int code;
    private final MidnightAuditing auditing;

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
        return MidnightStatus.READY;
    }
}
