package me.iqpizza6349.midnight.sample.event;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.event.message.MessageEvent;
import me.iqpizza6349.midnight.listener.message.MessageEventListener;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SuperBotMessageEvent implements MessageEventListener {

    private final BotProperties botProperties;
    private final KafkaMessageSender messageSender;

    @Override
    public void onMessageReceive(MessageEvent messageEvent) {
        final Message receivedMessage = messageEvent.getMessage();
        final String sender = receivedMessage.getSender();
        final String content = receivedMessage.getContent();

        if (sender.equals(botProperties.getName())) {
            // 본인이 전송한 메시지
            return;
        }

        if (!content.startsWith("반가워")) {
            return;
        }

        final String message = String.format("나도 만나서 반가워, %s!", sender);
        messageSender.sendMessage(new Message(botProperties.getName(), message));
    }
}
