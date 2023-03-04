package me.iqpizza6349.midnight.core.utils;

import lombok.*;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BotApiUtil {

    private static final String BASE_URL = "http://localhost:8090/bot";

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class BotResponse {
        private final String name;
        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public static class ResponseObject {
        private final int code;
        private final BotResponse response;
    }

    public static ResponseObject requestFindBot(String token) {
        final int[] code = new int[1];
        final BotResponse response;
        try {
             response = request("?token=", token)
                     .accept(MediaType.APPLICATION_JSON)
                     .exchangeToMono(res -> {
                         code[0] = res.statusCode().value();
                         System.out.println(res.statusCode().value());
                         if (res.statusCode().is2xxSuccessful()) {
                             return res.bodyToMono(BotResponse.class);
                         }
                         else {
                             return res.createException().flatMap(Mono::error);
                         }
                     })
                     .block();
        } catch (Exception e) {
            return new ResponseObject(code[0], null);
        }
        return new ResponseObject(code[0], response);
    }

    private static WebClient.RequestHeadersSpec<?> request(String uri, String parameter) {
        return WebClient.create(BASE_URL)
                .get()
                .uri(uri + parameter)
                .accept(MediaType.APPLICATION_JSON);
    }
}
