package com.rabbitmq.test.api.keyword.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExcelRepositoryImpl implements ExcelRepository{

    private final ExcelMapper excelMapper;

    @Override
    public List<Excel> excelList() {
        return excelMapper.findAll();
    }

    @Override
    public void excelInsert(Excel excel) {
        excelMapper.insert(excel);
    }

    @Override
    public void excelUpdate(Excel excel) {
        excelMapper.update(excel);
    }
}
