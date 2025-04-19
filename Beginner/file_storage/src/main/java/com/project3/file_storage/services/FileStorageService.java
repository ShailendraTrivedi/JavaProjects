package com.project3.file_storage.services;

import com.project3.file_storage.exceptions.FileStorageException;
import com.project3.file_storage.properties.FileStorageProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Service
public class FileStorageService {
    private Path fileStorageLocation;

    public FileStorageService(FileStorageProperties properties) {
        this.fileStorageLocation = Paths.get(properties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception e) {
            throw new RuntimeException("Could not create the upload directory!", e);
        }
    }

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
