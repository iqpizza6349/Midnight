package me.iqpizza6349.midnight.event.bot;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.constraints.bot.BotStatus;
import me.iqpizza6349.midnight.model.MidnightAuditing;

@RequiredArgsConstructor
public class BotShutdownEvent implements BotEvent {

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
    public BotStatus getStatus() {
        return BotStatus.SHUTDOWN;
    }
}
