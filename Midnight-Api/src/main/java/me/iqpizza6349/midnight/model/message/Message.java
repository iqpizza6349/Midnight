package me.iqpizza6349.midnight.model.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Message model class that send or receive with this class
 * must have sender(who send from), content, timestamp
 * @author iqpizza6349
 * @version 1.0
 */
@ToString
@Getter @Setter
@NoArgsConstructor
public class Message {
    private String sender;
    private String content;
    private String timestamp;
    private String destination;

    public Message(String sender, String content, String destination) {
        this.sender = sender;
        this.content = content;
        this.destination = destination;
        this.timestamp = LocalDateTime.now().toString();
    }
}
