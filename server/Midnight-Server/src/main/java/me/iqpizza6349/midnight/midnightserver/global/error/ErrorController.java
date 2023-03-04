package me.iqpizza6349.midnight.midnightserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {

    @Getter
    @Builder
    @AllArgsConstructor
    public static final class ExceptionDto {
        private final String message;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionDto> undefinedException(Exception ignored) {
        ExceptionDto dto = ExceptionDto.builder()
                .message("서버에서 예외가 발생했습니다.")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(dto);
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ExceptionDto> undefinedException(NoSuchElementException ignored) {
        ExceptionDto dto = ExceptionDto.builder()
                .message("ㅇㅅㅇ")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(dto);
    }

}
