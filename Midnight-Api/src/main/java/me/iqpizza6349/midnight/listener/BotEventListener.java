package me.iqpizza6349.midnight.listener;

import me.iqpizza6349.midnight.event.GeneralEvent;

/**
 * 봇 이벤트 발생 시, 동작할 행위들을 명시해둔 인터페이스
 */
public interface BotEventListener {

    /**
     * 발생하는 모든 이벤트를 받고 처리함
     * @param event 최상위 이벤트
     */
    void onEvent(GeneralEvent event);

}
