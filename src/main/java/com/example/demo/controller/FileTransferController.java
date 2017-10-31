package com.example.demo.controller;

import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lenovo on 2017/10/13.
 * 文件传输
 */
@RestController
@RequestMapping("/file")
public class FileTransferController {
    @Value("${web.upload-path}")
    private String mPath = "E:/accept/";

    @ResponseBody
    @PostMapping("/upload")
    ResponseDefault<String> upload(@RequestParam("file") MultipartFile file) {
        String path = FileUtil.upload(file, mPath);
        ResponseDefault<String> responseDefault = new ResponseDefault<>(path);
        if (path == null || path.length() == 0) {
            responseDefault.setStatus(400);
            responseDefault.setMessage("failed");
        }
        return responseDefault;
    }
}
