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
        File targetFile = new File(filePath);
        //文件保存路径
        String uploadFileName = null;
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            // 这里只是简单例子，文件直接输出到项目路径下。
            // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
            // 还有关于文件格式限制、文件大小限制，详见：中配置
            uploadFileName = getFileNameByTime(file.getOriginalFilename());
            out = new FileOutputStream(filePath + uploadFileName);
            out.write(file.getBytes());
            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            uploadFileName = null;
        } catch (IOException e) {
            e.printStackTrace();
            uploadFileName = null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uploadFileName;
    }

    /**
     *
     * @param fileName 文件名
     * @return 带时间后缀的文件名
     */
    private static String  getFileNameByTime(String fileName){
       return getFileName(fileName)+"_"+ System.currentTimeMillis()+"."+getExtension(fileName);
    }
    /**
     * @param name 文件名
     * @return 文件类型后缀
     */
    private static String getExtension(String name){
        String suffix= "";
        int idx = name.lastIndexOf('.');
        if (idx>0){
            suffix = name.substring(idx+1);
        }
        return suffix;
    }

    /**
     *
     * @param fileFullName 带后缀的文件名
     * @return 文件名
     */
    private static String getFileName(String fileFullName){
        String name;
        int idx = fileFullName.lastIndexOf('.');
        if (idx>0){
            name = fileFullName.substring(0,idx);
        }else {
            name = fileFullName;
        }
        return name;
    }

}
