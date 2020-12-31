package top.baomeier.rabbitmq.direct;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.baomeier.rabbitmq.fanout.FanoutReceiver;
import top.baomeier.rabbitmq.fanout.FanoutSender;


/**
 * @package: com.example.rabbitmq.config
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:34
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("exchange.direct");
    }

    @Bean
    public Queue directQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue directQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding directBinding1a(DirectExchange direct, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(direct).with("orange");
    }

    @Bean
    public Binding directBinding1b(DirectExchange direct, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(direct).with("black");
    }

    @Bean
    public Binding directBinding2a(DirectExchange direct, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(direct).with("green");
    }

    @Bean
    public Binding directBinding2b(DirectExchange direct, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(direct).with("black");
    }

    @Bean
    public DirectReceiver receiver() {
        return new DirectReceiver();
    }


    @Bean
    public DirectSender directSender() {
        return new DirectSender();
    }
}
