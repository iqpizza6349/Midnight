package me.iqpizza6349.midnight.event.close;

import lombok.Getter;
import me.iqpizza6349.midnight.event.GeneralEvent;

@Getter
public class CloseEvent extends GeneralEvent {

    private final String reason;

    public CloseEvent(String reason, int responseCode) {
        super(responseCode);
        this.reason = reason;
    }
}
