package jom.com.softserve.s6.task5;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) throw new NullPointerException();
        return map.values().stream()
                .flatMap(persons -> {
                    if (persons == null) return Stream.of();
                    return persons.toList().stream();
                })
                .filter(person -> Objects.nonNull(person) && !person.isBlank())
                .map(name -> name.toLowerCase().replaceAll("\\s+", ""))
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .map(name -> Character.toUpperCase(name.charAt(0)) + name.substring(1))
                .sorted();
    }
}
