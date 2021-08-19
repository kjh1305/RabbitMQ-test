package com.rabbitmq.test.api;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ExcelFile {
    private long id;
    private String file_name;
    private String file_type;
}
