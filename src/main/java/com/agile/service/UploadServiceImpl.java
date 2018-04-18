package com.agile.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService 
{
    private static String UPLOADED_FOLDER = "F://temp//";

    @Override
    public String saveUploadedFiles(MultipartFile file) throws IOException {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
}
