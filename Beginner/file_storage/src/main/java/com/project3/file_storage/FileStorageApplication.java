package com.project3.file_storage;

import com.project3.file_storage.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class FileStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileStorageApplication.class, args);
		System.out.println("Server Start Running...");
	}
}
