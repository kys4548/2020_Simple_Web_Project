package me.youngsil.testclone;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    @Test
    @DisplayName("첫번째 테스트")
    void test1() {
        Member member = new Member(1, "youngsil", 27);


        assertAll(
                () -> assertNotNull(member, () -> "null이 아니다"),
                () -> assertEquals(1, member.getId(), () -> "아이디가 다르다"),
                () -> assertFalse(member.getAge() > 100, () -> "나이기 100살보다 작다"),
                () -> assertThrows(IllegalArgumentException.class, () -> new Member(2, "kim", -5))
        );
    }

    @Test
    void test2() {
        assertTimeout(Duration.ofMillis(200), () -> {
            Thread.sleep(1000);
        }, () -> "시간 초과");
    }



    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void beforeEach() {

    }

    @AfterEach
    void afterEach() {

    }
}
