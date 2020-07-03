package me.youngsil.java8to11;


/**
 *  함수형 인터페이스는 오직 메서드를 하나만 가진다.
 *  abstract메서드가 한개면 무조건 함수형 인터페아스
 */

@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName() {
        System.out.println("Youngsil");
    }

    default void printAge() {
        System.out.println("27");
    }
}