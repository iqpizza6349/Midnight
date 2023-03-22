package me.iqpizza6349.midnight.model.channel;

import me.iqpizza6349.midnight.model.message.Message;

public interface Channel {

    String getTopic();

    void sendMessage(String text);

    void sendMessage(Message message);

}
