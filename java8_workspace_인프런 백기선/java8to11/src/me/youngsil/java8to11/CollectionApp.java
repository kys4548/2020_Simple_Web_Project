package me.youngsil.java8to11;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionApp {

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit();

        while(spliterator.tryAdvance(System.out::println));
        System.out.println("========================:");
        while(spliterator2.tryAdvance(System.out::println));
        System.out.println("++++++++++++++++++++++++++++");

        List<String> a = names.stream().map(String::toUpperCase)
                .distinct().peek(System.out::println).sorted()
                .collect(Collectors.toList());

        String[] arr = a.toArray(String[]::new);

        System.out.println(a.toString());
        System.out.println("====================");
        System.out.println(Arrays.toString(arr));

        //names.removeIf(s -> s.startsWith("a"));
        //names.remove("a");
        //System.out.println(names);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
    }
}
