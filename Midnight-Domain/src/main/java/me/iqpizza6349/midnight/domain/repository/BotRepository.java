package me.iqpizza6349.midnight.domain.repository;

import me.iqpizza6349.midnight.domain.entity.Bot;

import java.util.Optional;

public interface BotRepository {

    Bot save(Bot bot);

    Optional<Bot> findById(Long id);

    Optional<Bot> findByToken(String token);

    void delete(Bot bot);

}
