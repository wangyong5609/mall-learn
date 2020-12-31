package top.baomeier.rabbitmq.work;

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

public class WorkSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE_NAME = "work.hello";

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
        LOGGER.info(" [x] Sent '{}'", message);
    }
}
