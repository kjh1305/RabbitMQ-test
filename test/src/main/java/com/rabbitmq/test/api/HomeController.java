package com.rabbitmq.test.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final Produce produce;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("test")
    public String test(@RequestPart("file")MultipartFile file) throws Exception {
        produce.sendMessage(file);
        return "queue test";
    }
}
