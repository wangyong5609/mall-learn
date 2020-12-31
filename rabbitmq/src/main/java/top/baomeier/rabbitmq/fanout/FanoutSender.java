package top.baomeier.rabbitmq.fanout;

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

public class FanoutSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static  final String exchangeName = "exchange.fanout";

    public void send(int index){
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(exchangeName, "", message);
        LOGGER.info(" [x] Sent '{}'", message);
    }
}
