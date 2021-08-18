package com.rabbitmq.test.api;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void fileUploadInput(MultipartFile file, String filename) throws Exception;
    void fileUploadResult(String s) throws Exception;
}
