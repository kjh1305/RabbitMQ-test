package com.rabbitmq.test.api.keyword.excel;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExcelMapper {

    @Select("select id, filename, start_time, end_time, status_code, download_name from work")
    List<Excel> findAll();

    @Insert("insert into work(filename, status_code) values(#{filename}, #{status_code})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Excel excel);

    @Update("update work set end_time=#{end_time}, status_code=#{status_code}, download_name=#{download_name} where id=#{id}")
    void update(Excel excel);
}
