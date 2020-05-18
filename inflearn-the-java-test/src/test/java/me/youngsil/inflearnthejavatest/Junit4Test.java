package me.youngsil.inflearnthejavatest;

import org.junit.Before;
import org.junit.Test;

public class Junit4Test {

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
