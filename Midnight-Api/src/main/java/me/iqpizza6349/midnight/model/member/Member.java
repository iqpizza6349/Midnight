package me.iqpizza6349.midnight.model.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Member(Client) class with has only name(sender)
 */
@Getter
@ToString
@RequiredArgsConstructor
public class Member {

    private final String username;

}
