package me.iqpizza6349.midnight.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "me.iqpizza6349.midnight")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
