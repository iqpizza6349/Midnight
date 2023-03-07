package me.iqpizza6349.midnight.core.handler;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.listener.join.JoinEventListener;
import me.iqpizza6349.midnight.model.message.Message;

@RequiredArgsConstructor
public class DefaultMemberJoinHandler implements JoinEventListener {

    private final KafkaMessageSender messageSender;
    private final BotProperties botProperties;

    @Override
    public void onMemberJoin(MemberEvent event) {
        messageSender.sendMessage(welcomeMessage(event.getMember().getName()));
    }

    protected Message welcomeMessage(String username) {
        return new Message(botProperties.getName(), String.format("Hello, %s!", username));
    }

}
