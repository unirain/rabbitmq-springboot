package com.example.demo.mq;

import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 接收
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/27
 *
 *******************************************************************************/

@Component
//@RabbitListener(queues = "clm")
public class MqAcept {
    //参数名称会自动解析内容
//    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver : " + hello);
        throw new RuntimeException("测测");
    }

}
