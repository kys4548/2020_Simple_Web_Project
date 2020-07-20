package me.youngsil.inflearnthejavatest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

/*
어노테이션으로 지정하면 변수값을 바꿀 수 없다.
 */
//@ExtendWith(Extension.class)
public class ExtensionTest {

    /*
    필드에 정의하면 변수값을 바꿀 수 있다.
    대신에 생성자 메서드 만들어야 한다.
    static으로 정의되어야 한다.
     */

    @RegisterExtension
    static Extension extension = new Extension(1000L);


    @SlowTest
    void test1() throws InterruptedException {
        Thread.sleep(1005L);
    }

    @Test
    void test2() throws InterruptedException {
        Thread.sleep(1005L);
    }

}
