package com.rabbitmq.test.api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final Produce produce;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("test")
    public String test() throws Exception {
        for(int i=1; i<=5; i++){
            produce.sendMessage(i);
            produce.sendMessage(i);
            produce.sendMessage(i);
            produce.sendMessage(i);
            produce.sendMessage(i);
//            Thread.sleep(3000);
        }
        return "index";
    }
}
