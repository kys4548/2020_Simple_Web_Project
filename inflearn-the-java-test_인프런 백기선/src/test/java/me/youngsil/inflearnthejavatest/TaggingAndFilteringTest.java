package me.youngsil.inflearnthejavatest;

/*
    태깅 : 우리가 만든 여러개의 테스트를 그룹화하는 기능
        모듈별, 단위테스트, 통합테스트, 오래걸리는지 빨리걸리는지
        여러가지 조건으로 그룹화 가능

    필터링 : 필터를 적용하여 선택한 태깅만 테스트 실행
 */

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * window 환경에서
 * ex) mvnw.cmd test -P ci
 */

public class TaggingAndFilteringTest {

    @Test
    @Tag("fast")
    void test1() {

    }

    @Test
    @Tag("slow")
    void test2() {

    }
}
