package me.youngsil.inflearnthejavatest;

/**
 * junit에서 제공하는 Annotation은
 * meta annotaion 기능을 제공한다.
 *
 * ex)
 * Target : 해당 어노테이션 사용 범위 지정
 * Retention : 해당 어노테이션 적용 시점 지정
 * Documented : 해당 어노테이션을 javadoc에 포함
 * Inherited : 해당 어노테이션을 서브 클래스에도 상속
 */
public class MetaAnnotationTest {

    @FastTest
    void fast() {

    }

    @SlowTest
    void slow() {

    }
}
