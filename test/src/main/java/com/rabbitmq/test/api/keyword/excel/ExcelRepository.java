package com.rabbitmq.test.api.keyword.excel;

import java.util.List;

public interface ExcelRepository {

    List<Excel> excelList();
    void excelInsert(Excel excel);
    void excelUpdate(Excel excel);
}
