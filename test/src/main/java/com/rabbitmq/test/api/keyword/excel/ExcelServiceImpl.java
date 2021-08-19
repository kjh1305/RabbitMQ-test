package com.rabbitmq.test.api.keyword.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService{

    private final ExcelRepository excelRepository;

    @Override
    public List<Excel> findAll() {
        return excelRepository.excelList();
    }
}
