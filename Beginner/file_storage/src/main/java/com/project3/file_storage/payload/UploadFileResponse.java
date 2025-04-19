package com.project3.file_storage.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUrl;
    private String fileType;
    private long size;
}
