package com.rabbitmq.test.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    @Value("D:\\upload\\input\\")
    private String INPUT_FILE_PATH;

    @Value("D:\\upload\\result\\")
    private String RESULT_FILE_PATH;

    @RabbitListener(queues = "temp_test")
    public void receiveMessage(Message message) throws Exception{
        String s = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("큐 메세지 수신 message = {}", s);
//        Thread.sleep(3000);
    }
}
