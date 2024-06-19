package com.example.mqpublisher;

import com.example.mqpublisher.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class mqController {
    public static final String EXCHANGE_NAME = "sample.jh2022101";
    public static final String QUEUE_NAME = "sample.queuejh2022101";
    public static final String ROUTING_KEY = "sample.routingkey.jh2022101";
    private final RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/sample/queue", method = RequestMethod.POST)
    public String samplePublish(@RequestBody Message message){
//    public String samplePublish(@RequestBody Message message){
        log.info("Publishing message to queue");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
        log.info("Message sent to the queue: RabbitMQ + SpringBoot = Success");
        return "Message sending!";
    }
}
