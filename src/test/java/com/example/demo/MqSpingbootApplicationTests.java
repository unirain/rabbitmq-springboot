package com.example.demo;

import com.example.demo.mq.MqSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSpingbootApplicationTests {
    @Autowired
    private MqSend mqSend;

    @Test
    public void contextLoads() {
        for (int i=0;i<10;i++){

            mqSend.send();
        }
    }

}
