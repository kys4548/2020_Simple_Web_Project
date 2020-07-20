package me.youngsil.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class GreetingApp {
    public static void main(String[] args) {

        UnaryOperator<String> hi = Greeting::hi;

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        Supplier<Greeting> makeInstance = Greeting::new;

        Greeting greeting1 = makeInstance.get();
        Greeting greeting2 = makeInstance.get();

        Function<String, Greeting> makeInstance2 = Greeting::new;
        Greeting youngsil = makeInstance2.apply("youngsil");
        System.out.println(youngsil.getName());

        String[] names = {"ge" ,"a" ,"b", "c", "d"};

        //Arrays.sort(names, (s1, s2) -> s1.compareTo(s2));
        Arrays.sort(names,String::compareTo);
        System.out.println(Arrays.toString(names));

    }
}
