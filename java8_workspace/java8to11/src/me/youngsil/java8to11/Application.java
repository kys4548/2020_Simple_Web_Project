package me.youngsil.java8to11;

import java.util.function.*;

public class Application {

    public static void main(String[] args) {
        //함수형 인터페이스 사용
        RunSomething rs1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("test1");
            }
        };
        rs1.doIt();

        RunSomething rs2 = () -> System.out.println("test2");
        rs2.doIt();

        RunSomething rs3 = new RunSomethingImpl();



        //인테페이스의 static 메소드 사용
        //static 메소드 : 클래스에서만 사용가능
        RunSomething.printName();


        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));


        Function<Integer, Integer> plus5 = a -> a +5;
        Function<Integer, Integer> multiply2 = i -> i*2;

        System.out.println(plus5.apply(10));
        System.out.println(multiply2.apply(10));

        Function<Integer, Integer> result = plus10.compose(multiply2);
        System.out.println(result.apply(10));

        Function<Integer, Integer> result2 = plus10.andThen(multiply2);
        System.out.println(result2.apply(10));

        System.out.println("------------------------------");
        Consumer<Integer> printT = System.out::println;
        printT.accept(6);

        Supplier<Integer> returnT = () -> 10;
        System.out.println(returnT.get());

        System.out.println("===================================");

        Predicate<String> startWithYoungsil = s -> s.startsWith("youngsil");

        System.out.println(startWithYoungsil.test("youngsdl"));
        System.out.println("--------------------------------------------");


        UnaryOperator<Integer> unaryOperator = i -> i+10;
        BinaryOperator<Integer> binaryOperator = Integer::sum;

        Application app = new Application();
        app.run();


    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            int baseNumber = 5;
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }
        LocalClass lc = new LocalClass();
        lc.printBaseNumber();

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };
        integerConsumer.accept(3);

        IntConsumer intConsumer = System.out::println;

        intConsumer.accept(baseNumber);

    }
}
