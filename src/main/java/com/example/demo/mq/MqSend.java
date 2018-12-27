package com.example.demo.mq;

//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/********************************************************************************
 *
 * Title: 消息发送者
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/27
 *
 *******************************************************************************/
@Component
public class MqSend {
    @Autowired
//    private AmqpTemplate amqpTemplate;
    public void send(){
        String message="现在的时间"+ LocalDateTime.now();
        System.out.println(message);
//        amqpTemplate.convertAndSend("clm",message);
    }
}
