package top.baomeier.rabbitmq.work;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @package: com.example.rabbitmq.simple
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:48
 */
@RabbitListener(queues = "work.hello")
public class WorkReceiver {
    private static Logger logger = LoggerFactory.getLogger(WorkReceiver.class);

    private final int instance;

    public WorkReceiver(int instance) {
        this.instance = instance;
    }

    @RabbitHandler
    public void receive(String in){
        StopWatch watch = new StopWatch();
        watch.start();
        logger.info("instance {} [X] received '{}'", this.instance, in);
        doWork(in);
        watch.stop();
        logger.info("instance {}  [ x ] done in {}s", this.instance, watch.getTotalTimeSeconds());
    }

    private void doWork(String string){
        for (char c : string.toCharArray()) {
            if (c == '.'){
                ThreadUtil.sleep(1000);
            }
        }
    }
}
