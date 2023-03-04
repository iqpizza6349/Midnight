package me.iqpizza6349.midnight.midnightserver.domain.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class BotRegistrationDto {

    @Size(min = 4)
    private String name;

    @Nullable
    private String description;

}
