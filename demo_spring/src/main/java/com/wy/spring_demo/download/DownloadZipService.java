package com.wy.spring_demo.download;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * @author HelloWorld
 * @date 2023/12/13 18:51
 * @email helloworld.dng@gmail.com
 */
@Service
public class DownloadZipService {
    @GetMapping("/download-zip")
    public ResponseEntity<byte[]> downloadZip() throws IOException {
        // 读取本地的 zip 文件
        String zipFilePath = "/Users/helloworld/workspace/sayhello.zip";
        Path path = Paths.get(zipFilePath);
        byte[] data = Files.readAllBytes(path);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "file.zip");
        headers.setContentLength(data.length);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
