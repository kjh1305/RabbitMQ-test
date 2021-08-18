package com.rabbitmq.test.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Produce {

    @Value("temp.test")
    private String TOPIC_EXCHANGE_NAME;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(int message) throws Exception{
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "temp.test.a",message);
        log.info("큐 메세지 전송 message = {}", message);
    }
}
