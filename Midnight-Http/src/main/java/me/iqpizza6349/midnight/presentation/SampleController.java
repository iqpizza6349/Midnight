package me.iqpizza6349.midnight.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/")
    public String hello() {
        return "hello, Midnight!";
    }

}
