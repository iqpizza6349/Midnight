package me.iqpizza6349.midnight.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomStringUtils {

    public static String createAlphabetic(int length) {
        return createRandomString(97, length, false);
    }

    public static String createAlphanumeric(int length) {
        return createRandomString(48, length, true);
    }

    static String createRandomString(int start, int length, boolean addNumber) {
        Random random = new Random();
        IntStream stream = random.ints(start, 122 + 1);
        if (addNumber) {
            stream = addNumberFilter(stream);
        }

        return stream.limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    static IntStream addNumberFilter(IntStream stream) {
        return stream.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97));
    }
}
