package com.zhang;

import com.zhang.service.UserSrevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ConsumerApplicationTests {

    @Autowired
    UserSrevice userSrevice;
    @Test
    void contextLoads() {
        userSrevice.byTicket();
    }

}
