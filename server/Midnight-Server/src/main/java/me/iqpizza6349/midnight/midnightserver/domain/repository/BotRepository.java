package me.iqpizza6349.midnight.midnightserver.domain.repository;

import me.iqpizza6349.midnight.midnightserver.domain.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {
}
