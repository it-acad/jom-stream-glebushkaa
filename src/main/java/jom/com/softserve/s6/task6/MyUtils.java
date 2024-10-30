package jom.com.softserve.s6.task6;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    private static final int MIN_PHONE_LENGTH = 7;
    private static final int CODE_LENGTH = 3;

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if(list.stream() == null) return Map.of();
        return list.stream()
            .flatMap(phones -> phones.toList().stream())
            .filter(Objects::nonNull)
            .map(phone -> phone.replaceAll("[\\s\\(\\)\\-]", ""))
            .filter(phone -> !phone.isBlank())
            .collect(Collectors.groupingBy(
                    phone -> {
                        if (phone.length() < MIN_PHONE_LENGTH) return "err";
                        if (phone.length() == MIN_PHONE_LENGTH) return "loc";
                        return phone.substring(0, CODE_LENGTH);
                    },
                    Collectors.collectingAndThen(
                        Collectors.toSet(),
                        phones -> phones.stream().map(
                            phone -> {
                                if (phone.length() <= MIN_PHONE_LENGTH) return phone;
                                return phone.substring(CODE_LENGTH);
                            }
                        ).sorted()
                    )
                )
            );
    }
}
