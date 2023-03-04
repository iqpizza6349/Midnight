package me.iqpizza6349.midnight.core.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.event.message.MessageEvent;
import me.iqpizza6349.midnight.listener.message.MessageEventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order
@Component
@RequiredArgsConstructor
public class DefaultMessageHandler implements MessageEventListener {

    @Override
    public void onMessageReceive(MessageEvent event) {
        int responseType = event.getResponseCode() / 100;
        switch (responseType) {
            case 2 -> log.info("{}: {}", event.getMember(), event.getMessage());
            case 4 -> log.warn("[{}] {}: {}", event.getResponseCode(), event.getMember(), event.getMessage());
            case 5 -> log.error("[{}] {}: {}", event.getResponseCode(), event.getMember(), event.getMessage());
        }
    }
}
