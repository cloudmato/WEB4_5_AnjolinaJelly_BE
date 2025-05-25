package com.jelly.zzirit.domain.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreSignedUploadInitiateRequest {
    private String originalFileName;
    private String fileType;
    private Long fileSize;
}