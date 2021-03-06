package com.rabbitmq.test.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final FileMapper fileMapper;

    @Value("D:\\upload\\input\\")
    private String INPUT_FILE_PATH;

    @Value("D:\\upload\\result\\")
    private String RESULT_FILE_PATH;

    @Override
    public void fileUploadInput(MultipartFile file, String filename) throws Exception {

        log.info("파일 업로드 시작");
        File newFileName = new File(INPUT_FILE_PATH + filename);
        log.info("newFile={}", newFileName);
        ExcelFile excelFile = new ExcelFile();
        excelFile.setFile_name(newFileName.getName());
        excelFile.setFile_type("input");
        fileMapper.fileSave(excelFile);
        file.transferTo(newFileName);
        log.info("파일 업로드 완료");
    }

    @Override
    public void fileUploadResult(String s) throws Exception {
        log.info("불러오기 할 파일이름 = {}", s);
        ExcelFile findFile = fileMapper.findByName(s);
        log.info("불러온 엑셀 파일 = {}", findFile);

        FileInputStream fileInputStream = new FileInputStream(INPUT_FILE_PATH + findFile.getFile_name());
        log.info("불러온 파일 = {}", findFile);

        log.info("파일 가공 시작");
        //파일 가공
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row = sheetAt.getRow(1);
        Cell cell = row.getCell(1);
        String stringCellValue = cell.getStringCellValue();

        XSSFWorkbook newWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = newWorkbook.createSheet("1");
        XSSFRow row1 = sheet.createRow(0);
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue(stringCellValue);
        log.info("파일 가공 완료");

        log.info("result 파일 업로드 전");
        //result 파일 업로드
        ExcelFile excelFile = new ExcelFile();
        excelFile.setFile_name("result" + findFile.getFile_name());
        excelFile.setFile_type("result");
        fileMapper.fileSave(excelFile);
        log.info("result 파일 업로드 = {}", excelFile);
        newWorkbook.write(new FileOutputStream(new File(RESULT_FILE_PATH + excelFile.getFile_name())));
        log.info("result 파일 업로드 완료");
    }

}
