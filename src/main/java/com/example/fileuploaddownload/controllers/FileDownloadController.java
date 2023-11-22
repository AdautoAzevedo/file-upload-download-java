package com.example.fileuploaddownload.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileDownloadController {
    
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        Resource resource = new ClassPathResource("static/image.jpg");

        if (!resource.exists()) {
            throw new RuntimeException("Image not found!");
        }

        String contentType = "image/jpeg";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachent; filename=\""+ resource.getFilename() + "\"")
                .body(resource);

        
    }
}
