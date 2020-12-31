package top.baomeier.rabbitmq.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.baomeier.rabbitmq.simple.SimpleReceiver;
import top.baomeier.rabbitmq.simple.SimpleSender;


/**
 * @package: com.example.rabbitmq.config
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:34
 */
@Configuration
public class WorkRabbitConfig {
    @Bean
    public Queue workQueue(){
        return new Queue("work.hello");
    }

    @Bean
    public WorkSender workSender(){
        return new WorkSender();
    }


    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver(1);
    }

    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver(2);
    }
}
