package me.youngsil.inflearnthejavatest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/*
테스트의 메서드마다 각각의 class 인스턴스를 생성하는것이
기본전략이다.

이유 : 테스트간의 의존성을 없애기 위해
테스트가 실행되는 순서에 따라 공유되는 값의 결과가 다르다.
기본적으로 순차적으로 메서드가 실행되지만 매번그럴것이라고 생각하면 안된다.


기존에 해당 방법밖에 없었지만 junit5에서는 전략을 바꾸는 기능이 생겼다.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstanceTest {

    int value = 0;

    /*
    TestInstance를 PER_CLASS전략으로 설정하면 beforeAll, afterAll을 static으로 설정하지 않아도 된다.
     */
    @BeforeAll
    void before() {

    }

    @Test
    void test1() {
        System.out.println(this);
        System.out.println(value++);
    }

    //1이 출력되는것을 예상하지만 0이 출력된다.
    //각각 다른 인스턴스이다.
    @Test
    void test2() {
        System.out.println(this);
        System.out.println(value);
    }
}
