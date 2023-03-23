package me.iqpizza6349.midnight.constraints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 현재 Midnight 프레임워크의 상태를 표현한다.
 * @author iqpizza6349
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public enum MidnightStatus {
    /**
     * Midnight 프레임워크가 동작 준비가 완료된 상태
     */
    READY,

    /**
     * Midnight 프레임워크가 종료되거나 종료 중인 상태
     */
    SHUTDOWN
}
