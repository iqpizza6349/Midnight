package me.iqpizza6349.midnight.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@NoArgsConstructor
public class Message {

    private String sender;

    private String content;

    private String timestamp;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now().toString();
    }
}
