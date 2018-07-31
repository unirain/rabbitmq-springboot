package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/31
 *
 *******************************************************************************/
@Component
@RabbitListener(queues = "clm")
public class MqAcept2 {
    @RabbitHandler
    public void process(String hello) {

        System.out.println("Receiver2 : " + hello);
    }
}
