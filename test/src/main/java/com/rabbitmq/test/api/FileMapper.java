package com.rabbitmq.test.api;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {

    @Insert("insert into excel_file(file_name, file_type) values(#{file_name}, #{file_type})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void fileSave(ExcelFile excelFile);

//    @Select("select * from excel_file where file_name = #{file_name} and file_type = #{file_type}")
//    ExcelFile findByName(ExcelFile excelFile);

    @Select("select * from excel_file where file_name = #{file_name}")
    ExcelFile findByName(String s);

}
