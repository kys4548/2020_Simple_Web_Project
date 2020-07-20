package me.youngsil.java8to11;

public interface SimpleInterface {

    static void prints() {
        System.out.println("static");
    }

    default void printd() {
        System.out.println("default");
    }

    void print();
}
