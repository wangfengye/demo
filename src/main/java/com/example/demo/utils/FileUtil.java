package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2017/10/13.
 */
public class FileUtil {
    /**
     *
     * @param file 上传文件
     * @param filePath 存储路径(暂不可用)
     * @return
     */
    public static String upload(MultipartFile file, String filePath) {
        String path = "src/main/resources/static/";//上传路径
        String path1="upload/";
        filePath =path+path1;
        File targetFile = new File(filePath);
        //文件保存路径
        String uploadPath = null;
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            // 这里只是简单例子，文件直接输出到项目路径下。
            // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
            // 还有关于文件格式限制、文件大小限制，详见：中配置
            out = new FileOutputStream(filePath + file.getOriginalFilename());
            out.write(file.getBytes());
            out.flush();
            out.close();
            uploadPath = path1 + file.getOriginalFilename();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            uploadPath = null;
        } catch (IOException e) {
            e.printStackTrace();
            uploadPath = null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return uploadPath;
        }
    }
}
