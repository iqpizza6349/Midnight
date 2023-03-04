package me.iqpizza6349.midnight.midnightserver.domain.dto.ro;

import lombok.Getter;
import me.iqpizza6349.midnight.midnightserver.domain.entity.Bot;

@Getter
public class BotRO {

    private final String name;
    private final String description;

    public BotRO(Bot bot) {
        this.name = bot.getName();
        this.description = bot.getDescription();
    }
}
