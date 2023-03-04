package me.iqpizza6349.midnight.core.configuration.construct;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.BotConfig;
import me.iqpizza6349.midnight.core.utils.BotApiUtil;
import me.iqpizza6349.midnight.event.GeneralEvent;
import me.iqpizza6349.midnight.event.close.CloseEvent;
import me.iqpizza6349.midnight.listener.init.BotConstructedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BotConstructConfiguration {

    private final BotConfig botConfig;
    private final ApplicationContext applicationContext;
    private final BotConstructedEventListener constructedEventListener;

    @PostConstruct
    private void botInit() {
        log.info("{}", botConfig.getToken());
        BotApiUtil.ResponseObject response = BotApiUtil.requestFindBot(botConfig.getToken());
        log.info("{}", response.getCode());
        log.info("{}", response.getResponse());
        if (response.getCode() != 200) {
            botShutdown(new CloseEvent("token is invalid", response.getCode()));
            return;
        }

        constructedEventListener.onSetup(new GeneralEvent(200) {
            @Override
            public int getResponseCode() {
                return super.getResponseCode();
            }
        });
    }

    @PreDestroy
    private void botClose() {
        constructedEventListener.onShutdown(new CloseEvent("shutdown by program closed", 200));
    }

    protected void botShutdown(CloseEvent closeEvent) {
        log.error("{}", closeEvent.getReason());
        SpringApplication.exit(applicationContext, () -> -1 * closeEvent.getResponseCode());
    }

}
