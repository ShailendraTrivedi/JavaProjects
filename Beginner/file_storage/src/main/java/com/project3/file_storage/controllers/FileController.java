package com.project3.file_storage.controllers;

import com.project3.file_storage.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileStorageService.storeFile(file);
    }

}
