package top.baomeier.rabbitmq.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @package: com.example.rabbitmq.simple
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:42
 */

public class SimpleSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static  final String QUEUE_NAME = "simple.hello";

    public void send(){

        String helloWorld = "hello world";
        this.rabbitTemplate.convertAndSend(QUEUE_NAME, helloWorld);
        LOGGER.info(" send '{}'", helloWorld);
    }
}
