package com.rabbitmq.test.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class Produce {

    @Value("temp.test")
    private String TOPIC_EXCHANGE_NAME;

    private final RabbitTemplate rabbitTemplate;
    private final FileService fileService;

    public void sendMessage(MultipartFile file) throws Exception {
        String filename = UUID.randomUUID() + file.getOriginalFilename();
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "temp.test.a", filename);
        log.info("큐 메세지 전송 message = {}", filename);
        fileService.fileUploadInput(file, filename);
    }
}
