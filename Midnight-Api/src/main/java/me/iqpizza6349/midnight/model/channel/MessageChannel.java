package me.iqpizza6349.midnight.model.channel;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.model.message.Message;
import me.iqpizza6349.midnight.util.MessageSender;

@RequiredArgsConstructor
public class MessageChannel implements Channel {

    private final String sender;
    private final String topic;
    private final MessageSender<Message> messageSender;

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public void sendMessage(String text) {
        sendMessage(new Message(sender, text));
    }

    @Override
    public void sendMessage(Message message) {
        messageSender.sendMessage(message, topic);
    }
}
