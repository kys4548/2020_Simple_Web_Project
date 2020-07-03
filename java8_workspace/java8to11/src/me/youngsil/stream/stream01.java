package me.youngsil.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class stream01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<100; i++) {
            list.add(i);
        }

        Comparator<Integer> comparator = Integer::compareTo;
        //list.stream().sorted(comparator.reversed()).forEach(System.out::println);
        list.parallelStream().peek(n -> {
            System.out.println(Thread.currentThread() + " " + n);
        }).collect(Collectors.toSet());
    }
}
