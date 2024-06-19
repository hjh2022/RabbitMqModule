package com.example.mqlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {

    private static final Logger log = LoggerFactory.getLogger(MqConsumer.class);

    @RabbitListener(queues = "sample.queuejh2022101")
    public void receieveMessage(String message){
        log.info("### message = {}",message);
    }
}
