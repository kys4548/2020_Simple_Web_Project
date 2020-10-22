package com.example.springboot21autoconfig;

import junit.framework.TestCase;
import org.junit.Test;

public class TestClassTest extends TestCase {

    @Test
    public void test1() {
        TestClass.m1();
        TestClass testClass = new TestClass();
        testClass.m2();
    }
}