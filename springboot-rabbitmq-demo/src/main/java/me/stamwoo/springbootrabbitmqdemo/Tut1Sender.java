package me.stamwoo.springbootrabbitmqdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


/**
 * @author woo
 */
public class Tut1Sender {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private Queue queue;

    /**
     * 用定时任务来模拟生产者定时发送消息
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!" + new Date();
        template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
