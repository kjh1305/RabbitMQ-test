package com.rabbitmq.test.api.keyword.excel;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private final ExcelService excelService;

    @GetMapping("/list")
    public Object getList(){
        List<Excel> excelList = excelService.findAll();
        return excelList;
    }

}
