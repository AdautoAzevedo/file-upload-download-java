package com.example.fileuploaddownload.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
   
   
    @GetMapping("/upload-form")
    public String showUploadForm() {
        return "upload-form";
    }
    
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        File uploadDir = new File("src\\main\\resources\\uploads\\");

        File destFile = new File(uploadDir+"/" + file.getOriginalFilename());
        
        file.transferTo(destFile);
        return "redirect:/upload-success";
    }
}
