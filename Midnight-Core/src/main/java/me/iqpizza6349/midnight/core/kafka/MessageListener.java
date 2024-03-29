package me.iqpizza6349.midnight.core.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.utils.sender.KafkaMessageSender;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Kafka Broker Listener class that needs {@link me.iqpizza6349.midnight.util.MessageSender}. <br>
 * which is using kafka (such as default message sender {@link KafkaMessageSender}
 * <br>
 * @author iqpizza6349
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
public class MessageListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(
            topics = "#{'${midnight.topic}'}"
    )
    public void listen(Message message) {
        messagingTemplate.convertAndSend(message.getDestination(), message);
    }
}
