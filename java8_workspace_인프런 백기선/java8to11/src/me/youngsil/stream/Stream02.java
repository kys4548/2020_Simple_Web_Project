package me.youngsil.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream02 {

    public static void main(String[] args) {
        List<OnlineClass> springClass = new ArrayList<OnlineClass>();
        springClass.add(new OnlineClass(1, "spring 1", true));
        springClass.add(new OnlineClass(2, "spring 2", true));
        springClass.add(new OnlineClass(3, "spring 3", false));
        springClass.add(new OnlineClass(4, "spring 4", false));
        springClass.add(new OnlineClass(5, "spring 5", false));

        System.out.println("spring으로 시작하는 수업");
        springClass.stream().map(OnlineClass::getTitle).filter(t -> t.startsWith("spring")).forEach(System.out::println);
        System.out.println("close 되지 않은 수업");
        springClass.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(System.out::println);
        System.out.println("수업이름만 모아서 스트림 만들기");
        springClass.stream().map(OnlineClass::getTitle).forEach(System.out::println);

        List<OnlineClass> javaClass = new ArrayList<OnlineClass>();
        javaClass.add(new OnlineClass(6, "java 6", true));
        javaClass.add(new OnlineClass(7, "java 7", true));
        javaClass.add(new OnlineClass(8, "java 8", false));

        List<List<OnlineClass>> youngEvent = new ArrayList<>();
        youngEvent.add(springClass);
        youngEvent.add(javaClass);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        youngEvent.stream().flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 test가 들어있는 수업이 있는지");
        boolean test = javaClass.stream().map(OnlineClass::getTitle).anyMatch(t -> t.contains("6"));
        System.out.println(test);

        System.out.println("스프링 수업 제목에 spring이 들어간 것만 모아서 리스트 만들기");
        List<OnlineClass> spring = springClass.stream().filter(o -> o.getTitle().contains("spring")).collect(Collectors.toList());
        System.out.println(spring);
    }
}
