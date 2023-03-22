package me.iqpizza6349.midnight.sample;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.core.configuration.BotProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleRunner implements CommandLineRunner {

    private final BotProperties properties;

    @Override
    public void run(String... args) {
        System.out.println(properties);
    }
}
