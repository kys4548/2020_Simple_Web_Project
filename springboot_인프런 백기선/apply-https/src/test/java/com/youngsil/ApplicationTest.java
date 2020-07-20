package com.youngsil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    void test01() {
        assertThat(environment.getProperty("youngsil.name"))
                .isEqualTo("kim young sil");
    }
}