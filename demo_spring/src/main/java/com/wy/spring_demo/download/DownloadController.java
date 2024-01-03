package com.wy.spring_demo.download;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author HelloWorld
 * @date 2023/12/13 18:54
 * @email helloworld.dng@gmail.com
 */
@RestController
public class DownloadController {
    @Resource
    private DownloadZipService downloadZipService;

    @GetMapping("/download/zip")
    public ResponseEntity<byte[]> downloadZip(String userId, String filePath) throws IOException {
        System.out.println(userId);
        System.out.println(filePath);
        return downloadZipService.downloadZip();
    }
}
