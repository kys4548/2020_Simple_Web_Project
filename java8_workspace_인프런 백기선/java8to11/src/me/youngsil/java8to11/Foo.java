package me.youngsil.java8to11;

import jdk.swing.interop.SwingInterOpUtils;

public interface Foo {

    void printName();


    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     * 구현한 클래스에서 오버라이딩으로 재정의 가능.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
