package com.rabbitmq.test.api.keyword.excel;

import java.util.List;

public interface ExcelService {

    List<Excel> findAll();
    void save(Excel excel);
    void change(Excel excel);
}
