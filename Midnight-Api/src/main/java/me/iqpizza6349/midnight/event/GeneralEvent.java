package me.iqpizza6349.midnight.event;

import me.iqpizza6349.midnight.model.MidnightAuditing;

/**
 * Top-level event interface that represents the events that might occur
 * in the Midnight framework <br>
 * @author iqpizza6349
 * @since 1.0
 */
public interface GeneralEvent {

    /**
     * HTTP 코드를 반환합니다. 기본 코드는 200 반환하도록 합니다.
     * returns HTTP code. default code is 200
     * @return HTTP code
     */
    int getResponseCode();

    /**
     * returns basic information about <strong>auto answer bot</strong>
     * @return basic information about bot
     */
    MidnightAuditing getAuditing();

}
