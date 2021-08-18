package com.rabbitmq.test.api;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {
    @Insert("insert into excel_file(file_name, file_type) values(#{filename}, #{filetype})")
    void fileSave(ExcelFile excelFile);

    @Select("select * from excel_file where file_name = #{name} and file_type = #{type}")
    ExcelFile findByName(String name, String type);

}
