package me.youngsil.testclone;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SequenceTest {

    @Test
    @Order(2)
    void test1() {

    }

    @Test
    @Order(1)
    void test2() {

    }
}
