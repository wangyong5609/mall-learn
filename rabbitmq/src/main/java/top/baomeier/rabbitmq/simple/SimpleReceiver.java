package top.baomeier.rabbitmq.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @package: com.example.rabbitmq.simple
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:48
 */
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {
    private static Logger logger = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(String in){
        logger.info(" [ x ] received '{}'", in);
    }
}
