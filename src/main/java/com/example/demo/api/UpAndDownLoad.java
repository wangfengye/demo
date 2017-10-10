package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by lenovo on 2017/9/12.
 */
@Controller
public class UpAndDownLoad {

    @RequestMapping("/file")
    public String file(){
        return "/file";
    }
    @ResponseBody
    @PostMapping("/file/upload")
    String upload(@RequestParam("file")MultipartFile file){
        String path = "src/main/resources/static/";//上传路径
        String path1="upload/";
        path =path+path1;
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path,file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return path1+file.getOriginalFilename();
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    @RequestMapping("/down/{path}")
    String download(@PathVariable String path){
        return "static/"+path;
    }

    @RequestMapping("/form")
    public String form(){
        return "/admin/mine/form_app";
    }

}
