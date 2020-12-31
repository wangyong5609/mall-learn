package top.baomeier.rabbitmq.controller;

import cn.hutool.core.thread.ThreadUtil;
import top.baomeier.rabbitmq.direct.DirectSender;
import top.baomeier.rabbitmq.fanout.FanoutSender;
import top.baomeier.rabbitmq.simple.SimpleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.baomeier.rabbitmq.topic.TopicSender;
import top.baomeier.rabbitmq.work.WorkSender;

/**
 * @package: com.example.rabbitmq.controller
 * @description:
 * @Author: wang yong
 * @Date: 2020/12/31 15:53
 */
@RestController
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;
    @Autowired
    private WorkSender workSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;
    @GetMapping("hello")
    public String hello() {
        return "helo";
    }

    @GetMapping("/simple")
    public void simpleTest() {
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            ThreadUtil.sleep(1000);
        }
    }

    @GetMapping("/work")
    public void workTest() {
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
            ThreadUtil.sleep(1000);
        }
    }

    @GetMapping("/fanout")
    public void fanoutTest() {
        for (int i = 0; i < 10; i++) {
            fanoutSender.send(i);
            ThreadUtil.sleep(1000);
        }
    }

    @GetMapping(value = "/direct")
    public void directTest() {
        for (int i = 0; i < 10; i++) {
            directSender.send(i);
            ThreadUtil.sleep(1000);
        }
    }

    @GetMapping(value = "/topic")
    public void topicTest() {
        for (int i = 0; i < 10; i++) {
            topicSender.send(i);
            ThreadUtil.sleep(1000);
        }
    }
}
