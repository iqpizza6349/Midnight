package me.iqpizza6349.midnight.event.bot;

import me.iqpizza6349.midnight.constraints.bot.BotStatus;
import me.iqpizza6349.midnight.event.GeneralEvent;

public interface BotEvent extends GeneralEvent {

    BotStatus getStatus();

}
