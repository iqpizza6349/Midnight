package me.iqpizza6349.midnight.core.event.listener.bot;

import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.midnight.MidnightReadyEvent;
import me.iqpizza6349.midnight.event.listener.AbstractEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultBotReadyListener extends AbstractEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBotReadyListener.class);

    @Override
    public void onEvent(GeneralEvent event) {
        if (event instanceof MidnightReadyEvent) {
            LOGGER.info("<{}> is ready!", event.getAuditing().getBotName());
        }
    }
}
