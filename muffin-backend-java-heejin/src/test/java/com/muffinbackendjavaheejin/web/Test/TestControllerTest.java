package com.muffinbackendjavaheejin.web.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class TestControllerTest {

    @Autowired TestController testController;

    @Test
    void helloWorld() {
        assertThat(testController.helloWorld()).isEqualTo("TDD Success !!");
    }
}