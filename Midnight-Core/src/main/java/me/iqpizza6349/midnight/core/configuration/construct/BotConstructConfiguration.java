package me.iqpizza6349.midnight.core.configuration.construct;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
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

    private final BotProperties botProperties;

    private final ApplicationContext applicationContext;
    private final BotConstructedEventListener constructedEventListener;

    @PostConstruct
    private void botInit() {
        System.out.println(applicationContext.getBeansOfType(BotProperties.class));
        final String token = botProperties.getToken();
        log.info("{}", token);
        BotApiUtil.ResponseObject response = BotApiUtil.requestFindBot(token);
        final int code = response.getCode();
        final BotApiUtil.BotResponse botResponse = response.getResponse();
        System.out.println(botResponse);

        if (code / 100 != 2) {
            log.error("status-code: {}", code);
            botShutdown(new CloseEvent("token is invalid", response.getCode()));
            return;
        }

        if (!(botResponse.getName().equals(botProperties.getName()))) {
            botShutdown(new CloseEvent("bot name is in-correct", 400));
            return;
        }

        log.info("status-code: {}", code);
        constructedEventListener.onSetup(new GeneralEvent(response.getCode()) {
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
