package com.agile.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	String saveUploadedFiles(MultipartFile file) throws IOException;

}
