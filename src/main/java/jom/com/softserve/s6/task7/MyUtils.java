package jom.com.softserve.s6.task7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    <T> Stream<T> duplicateElements(Stream<T> stream) {
        if (stream == null) return Stream.of();
        return stream
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .sorted();
    }

    public static void main(String[] args) {
        List<Integer> list = null;
        var utils = new MyUtils();
        var value = utils.duplicateElements(Stream.of(null));
        System.out.println(value.toList());
    }
}
