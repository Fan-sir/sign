package com.xk.sign;

import com.xk.sign.util.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignApplicationTests {

    @Test
    void contextLoads() {
        new TimeUtil().getWeek();
    }

}
