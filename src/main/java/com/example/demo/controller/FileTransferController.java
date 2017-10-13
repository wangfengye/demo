package com.example.demo.controller;

import com.example.demo.bean.responseBean.ResponseDefault;
import com.example.demo.utils.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lenovo on 2017/10/13.
 * 文件传输
 */
@RestController
@RequestMapping("/file")
public class FileTransferController {
    @ResponseBody
    @PostMapping("/upload")
    ResponseDefault<String> upload(@RequestParam("file") MultipartFile file) {
        String path = FileUtil.upload(file, null);
        ResponseDefault<String> responseDefault = new ResponseDefault<>(path);
        if (path == null || path.length() == 0) {
            responseDefault.setCode(400);
            responseDefault.setMessage("failed");
        }
        return responseDefault;
    }
}
