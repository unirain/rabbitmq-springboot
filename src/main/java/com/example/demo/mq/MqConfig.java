package com.example.demo.mq;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 配置
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/27
 *
 *******************************************************************************/
@Configuration
public class MqConfig {
//    @Bean
//    public Queue helloQueue() {
//        return new Queue("clm");
//    }
    final static String message = "topic.message";
    final static String messages = "topic.messages";

//    @Bean
//    public Queue queueMessage() {
//        return new Queue(MqConfig.message);
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue(MqConfig.messages);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("exchange");
//    }
//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//    }


}
