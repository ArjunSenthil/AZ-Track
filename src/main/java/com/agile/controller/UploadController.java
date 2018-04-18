package com.agile.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.agile.service.UploadServiceImpl;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@RequestMapping(path="/file")
@Controller
public class UploadController 
{ 
    @Autowired
    UploadServiceImpl uploadserviceimpl;
    
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody public ResponseEntity<?> uploadFile(@RequestBody MultipartFile uploadfile) 
    {
    	if (uploadfile.isEmpty()) {
            return new ResponseEntity<Object>("please select a file!", HttpStatus.NO_CONTENT);
        }

        try
        {
            uploadserviceimpl.saveUploadedFiles(uploadfile);

        } catch (IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>("Successfully uploaded - " +uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }
}