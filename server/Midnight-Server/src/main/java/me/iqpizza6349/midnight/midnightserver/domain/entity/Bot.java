package me.iqpizza6349.midnight.midnightserver.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import me.iqpizza6349.midnight.midnightserver.global.utils.RandomStringUtils;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = @Index(columnList = "token", unique = true))
public class Bot {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String token = RandomStringUtils.createAlphanumeric(26);

    @Builder.Default
    private String name = "demo_bot";

    private String description;

}
