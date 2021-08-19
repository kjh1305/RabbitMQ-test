package com.rabbitmq.test.api.keyword.excel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExcelMapper {

    @Select("select id, filename, start_time, end_time, status_code, download_name from work")
    List<Excel> findAll();
}
