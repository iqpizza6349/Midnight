package me.iqpizza6349.midnight.core.handler;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.utils.KafkaMessageSender;
import me.iqpizza6349.midnight.event.member.MemberEvent;
import me.iqpizza6349.midnight.listener.join.JoinEventListener;
import me.iqpizza6349.midnight.model.message.Message;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order
@Component
@RequiredArgsConstructor
public class DefaultMemberJoinHandler implements JoinEventListener {

    private final KafkaMessageSender messageSender;

    @Override
    public void onMemberJoin(MemberEvent event) {
        messageSender.sendMessage(welcomeMessage(event.getMember().getName()));
        System.out.println("wjsthd");
    }

    protected Message welcomeMessage(String username) {
        return new Message("bot", String.format("Hello, %s!", username));
    }

}
