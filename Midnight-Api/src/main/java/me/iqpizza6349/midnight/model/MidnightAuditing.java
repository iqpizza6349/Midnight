package me.iqpizza6349.midnight.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Basic information for implementing bots in the Midnight framework
 * @author iqpizza6349
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public class MidnightAuditing {

    /**
     * bot name, which is default name to send message with channel class
     * @see me.iqpizza6349.midnight.model.message.Message
     * @see me.iqpizza6349.midnight.model.channel.Channel
     */
    private final String botName;

}
