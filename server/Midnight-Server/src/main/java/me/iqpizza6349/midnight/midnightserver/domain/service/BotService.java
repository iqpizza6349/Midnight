package me.iqpizza6349.midnight.midnightserver.domain.service;

import lombok.RequiredArgsConstructor;
import me.iqpizza6349.midnight.midnightserver.domain.dto.BotRegistrationDto;
import me.iqpizza6349.midnight.midnightserver.domain.dto.ro.BotRO;
import me.iqpizza6349.midnight.midnightserver.domain.entity.Bot;
import me.iqpizza6349.midnight.midnightserver.domain.repository.BotRepository;
import me.iqpizza6349.midnight.midnightserver.domain.dto.ro.BotRegistrationRO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BotService {

    private final BotRepository botRepository;

    // 봇을 등록, 갱신, 삭제할 수 있어야 한다.
    // 추가로 조회 역시 가능해야 한다.

    public BotRegistrationRO registrationBot(final BotRegistrationDto registrationDto) {
        Bot bot = Bot.builder()
                .name(registrationDto.getName())
                .description(registrationDto.getDescription())
                .build();
        botRepository.save(bot);
        return new BotRegistrationRO(bot.getToken());
    }

    @Transactional(readOnly = true)
    public BotRO findBot(final String token) {
        Bot bot = botRepository.findByToken(token)
                .orElseThrow();
        return new BotRO(bot);
    }




}
