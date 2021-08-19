package com.rabbitmq.test.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    private final FileService fileService;

    @RabbitListener(queues = "temp_test")
    public void receiveMessage(Message message) throws Exception {
        log.info("큐 메세지 수신 message = {}", message);
        String s = new String(message.getBody(), StandardCharsets.UTF_8);
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(s);
        log.info("큐 메세지 수신 s = {}", s);
        log.info("큐 메세지 수신 data = {}", data);
        String file_name = String.valueOf(data.get("file_name"));
        fileService.fileUploadResult(file_name);
    }
}
