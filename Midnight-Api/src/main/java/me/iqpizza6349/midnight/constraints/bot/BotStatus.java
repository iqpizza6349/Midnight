package me.iqpizza6349.midnight.constraints.bot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BotStatus {
    OFFLINE(0),
    ONLINE(1)
    ;
    private final int status;
}
