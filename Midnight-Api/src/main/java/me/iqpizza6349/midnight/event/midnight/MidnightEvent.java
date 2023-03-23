package me.iqpizza6349.midnight.event.midnight;

import me.iqpizza6349.midnight.constraints.MidnightStatus;
import me.iqpizza6349.midnight.event.GeneralEvent;

/**
 * Event interface to detect Midnight framework behavior <br>
 * you can get the status of Midnight through {@link #getStatus()}
 * @since 1.0
 * @author iqpizza6349
 */
public interface MidnightEvent extends GeneralEvent {

    /**
     * returns state of Midnight
     * @see MidnightStatus
     * @return state of Midnight
     */
    MidnightStatus getStatus();

}
