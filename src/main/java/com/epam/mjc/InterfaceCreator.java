package com.epam.mjc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(x -> x.charAt(0)>=65 && x.charAt(0)<=90);
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> integerList = list.stream().filter(x -> x % 2 == 0).toList();
            list.addAll(integerList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(x -> x.charAt(0) >= 'A' && x.charAt(0) <= 'Z' && x.endsWith(".") && x.trim().split(" ").length > 2)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String, Integer> map = new HashMap<>();
        return list -> list.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
