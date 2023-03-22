package me.iqpizza6349.midnight.event;

import me.iqpizza6349.midnight.model.MidnightAuditing;

public interface GeneralEvent {

    /**
     * HTTP 코드를 반환합니다. 기본 코드는 200 반환하도록 합니다.
     * @return HTTP 코드를 반환
     */
    int getResponseCode();

    MidnightAuditing getAuditing();


}
