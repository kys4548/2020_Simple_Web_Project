package me.youngsil.inflearnthejavatest;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 *  junit4에서는 테스트로 쓰이는 클래스와 메서드는 모두 public
 *  junit5에서는 public로 자동 지정해준다.
 *  바이트코드는 변경 x, 리플렉션을 이용.
 */


//클래스, 메소드 모두에 적용가능
//테스트 이름 전략 설정( 해당 전략은 언더바 없애고 보여주는 전략 )
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {



    @Test
    //테스트에 직접 이름 지정하는 방법
    @DisplayName("스터디 만들기 \uD83D\ude31 ೭੧(❛〜❛✿)੭೨")
    void create_new_study() {
        Study study = new Study(10);
        /**
         * assert1
         */
        //assertNotNull(study);

        /*
        assertEquals메서드 안을 살펴보면 expected, actual 순서로 파라미터가 되어있다.
        따라서 그 순서에 맞게 값을 지정해주는게 좋다.
         */


        /*
            그냥 문자열을 넣는것이 아니라 람다식을 사용하면 좋은 이유
            테스트를 실패했을때만 이 문자열 연산을 하는 이점이 있다.
            문자열이면 성공이든 실패든 연산을 진행한다.
            ==> 성능상의 이점
         */

        /**
         * aseert2
         */
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다");
//
        /**
         * assert3
         */
//        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");
//

        /*
        만약 위에 검증에서 실패한다면 아래 문제는 검증할 수 없다.
        한번에 모든 문제를 다 검증하고 싶다면 assertAll메서드를 사용하자.
         */

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다"),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );


        //객체에서 던진는는 exception 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야 한다.", message);

        /*
        우리가 실행하는 코드가 특정한 시간내에 완료가 되는지 test
        시간제한을 100으로 했지만 내부 코드가 모두 실행된 후 종료 된다.
        1000의 시간이 걸린다.
         */
        assertTimeout(Duration.ofMillis(300), () -> {
            new Study(10);
            Thread.sleep(100);
        }, () -> "Time out 발생");

        /*
        제한시간을 넘기면 어차피 내부코드를 모두 실행할 필요가 없으니
        제한시간을 넘기면 종료하는 메서드

        주의점 : 예상치 못한 에러가 발생할 수도 있다.
        파라미터로 넘겨진 블럭을 별도의 thread로 실행한다.
        spring에서는 thread 기본전략으로 threadLocal을 사용한다.(모른다.)
        test는 하나의 tranaction이 끝이나면 rollback이 되야하는데 제대로 적용이 안될 수도 있다.

        tranaction을 가지고 있는 thread와 별개로 다른 thread가 실행되므로
        값이 DB에 반영될수도 있다.

        알아서 잘 선택해서 사용하자.
         */
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            new Study(10);
            Thread.sleep(100);
        }, () -> "time out 발생");
    }

    @Test
    //@Disabled
    void create_new_study_again() {
        System.out.println("create1");
    }


    @Test
    @DisplayName("Assertj Test")
    void assertj() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    //특정환경에서만 해당 test를 실행하는 방법
    @Test
    @DisplayName("assumeTrue Test")
    void assume1() {

        //맞다면 아래 TEST 실행
        System.out.println(System.getenv("TEST_ENV"));
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        Study study = new Study(10);
        assertEquals(10, study.getLimit(), () -> "limit값 검증 실패");
    }

    @Test
    @DisplayName("assumingThat")
    void assume2() {
        //조건에 따라 테스트 실행
        String test_env = System.getenv("TEST_ENV");
        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {

        });

        assumingThat("youngsil".equalsIgnoreCase(test_env), () -> {

        });
    }

    @Test
    @DisplayName("assume3")
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void assume3() {

    }

    @Test
    @DisplayName("assume4")
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    void assume4() {

    }

    @Test
    @DisplayName("assume5")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void assume5() {

    }


    //모든 테스트를 실행하기전 딱 한번만 실행되는 메서드
    //반드시 static를 붙여야 한다.
    //private는 불가
    //return 타입이 있으면 안된다.
    //static void를 기본으로 한다.
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }


    //모든 테스트를 실행할 때 각각의 테스트를 실행하기 전에 실행된다.
    // 따라서 static을 쓸 필요가 없다.
    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}