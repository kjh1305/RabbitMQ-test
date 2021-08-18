package com.rabbitmq.test.api;

import lombok.Data;

@Data
public class ExcelFile {
    private long id;
    private String filename;
    private String filetype;
}
