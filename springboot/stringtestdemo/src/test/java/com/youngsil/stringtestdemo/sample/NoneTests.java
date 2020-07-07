package com.youngsil.stringtestdemo.sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoneTests {

    @Autowired
    SampleController sampleController;

    @MockBean
    SampleService sampleService;

    @Test
    void test01() {
        when(sampleService.getName()).thenReturn("test!");

        assertThat(sampleController.hello()).isEqualTo("hello test!");
    }
}
