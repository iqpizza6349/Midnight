package me.iqpizza6349.midnight.event;

import lombok.RequiredArgsConstructor;

/**
 * 최상위 이벤트 추상 클래스
 */
@RequiredArgsConstructor
public abstract class GeneralEvent {

    protected final int responseCode;

    /**
     * HTTP 코드를 반환합니다. 기본 코드는 200 반환하도록 합니다.
     * @return HTTP 코드를 반환
     */
    public int getResponseCode() {
        return responseCode;
    }
}
