package com.rabbitmq.test.api.keyword.excel;


import com.rabbitmq.test.api.Produce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private final ExcelService excelService;
    private final Produce produce;

    @GetMapping("/list")
    public Object getList(){
        List<Excel> excelList = excelService.findAll();
        return excelList;
    }

//    @PostMapping("/upload")
//    public Object upload(@RequestPart("file") MultipartFile file) throws Exception {
//        produce.sendMessage(file);
//        ExcelStatus excelStatus = new ExcelStatus();
//        excelStatus.setStatus(1);
//        excelStatus.
//        return ;
//    }

}
