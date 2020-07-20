package me.youngsil.inflearnthejavatest;

import org.junit.jupiter.api.*;

/*
기본적으로 test는 특정한 로직에 의해 실행되는 순서가 정해져있다.
(JVM내부 설정에 따라)

사용자는 그 순서에 의존하면 안된다.
언제든지 바뀔수가 있기 때문이다.

순서를 정확하게 드러내지 않은 이유

단일테스트에서는 test메서드는 각 메서드마다 독립성이 유지되어야 한다.
다르코드에 영향을 주면 안돼!

통합 테스트나 시나리오 테스트 등의 경우에서는
내가 원하는 순서대로 test를 진행하고 싶을 수도 있다.
상태정보를 유지하고 테스트간의 의존성도 존재, 데이터 공유
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/*
TestMethodOrder안의 파라미터로 3가지 구현제를 설정 가능
- Alpanumeric
- OrderAnnotion
- Random
 */
public class SequenceTest {

    int value = 0;

    @Test
    @Disabled
    @Order(2)
    void test_1() {
        System.out.println("value = " + value);
    }

    @Test
    @Order(1)
    void test2() {

    }

    @Test
    @Order(-100)
    void test3() {
        System.out.println("value = " + value++);
    }
}
