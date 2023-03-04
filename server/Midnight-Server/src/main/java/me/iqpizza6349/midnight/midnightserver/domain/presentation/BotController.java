package me.iqpizza6349.midnight.midnightserver.domain.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.midnightserver.domain.dto.BotRegistrationDto;
import me.iqpizza6349.midnight.midnightserver.domain.dto.ro.BotRO;
import me.iqpizza6349.midnight.midnightserver.domain.dto.ro.BotRegistrationRO;
import me.iqpizza6349.midnight.midnightserver.domain.service.BotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bot")
public class BotController {

    private final BotService botService;

    @PostMapping("/create")
    public BotRegistrationRO createBot(@RequestBody @Valid BotRegistrationDto registrationDto) {
        return botService.registrationBot(registrationDto);
    }

    @GetMapping
    public BotRO findBotByToken(@RequestParam @Valid String token) {
        System.out.println(token);
        return botService.findBot(token);
    }


}
