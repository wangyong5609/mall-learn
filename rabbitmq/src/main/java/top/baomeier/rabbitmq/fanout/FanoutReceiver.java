package top.baomeier.rabbitmq.fanout;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @package: top.baomeier.rabbitmq.fanout
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 17:13
 */
public class FanoutReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receive1(String in){
        receive(in ,1);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receive2(String in){
        receive(in ,2);
    }

    public void receive(String in, int receiver){
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [X] received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        LOGGER.info("instance {}  [ x ] done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }

}
