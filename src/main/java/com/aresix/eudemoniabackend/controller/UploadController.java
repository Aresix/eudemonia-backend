package com.aresix.eudemoniabackend.controller;

import com.aresix.eudemoniabackend.common.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping(value = "/upload")
    public String upload(){
        return "upload";
        // 这里直接去src/main/resources/templates下找同名文件
    }


    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("userImgPath") MultipartFile file){
        // 获取文件扩展名
        if (file!=null){
            String fileOriginalName=file.getOriginalFilename();
            if (fileOriginalName!=null){
                // 获取扩展名
                String extend = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
                String newFileName = UUID.randomUUID().toString()+extend;
                File file1 = new File(Const.UPLOAD_IMG_PATH,newFileName);

                try {
                    file.transferTo(file1);
                    return "127.0.0.1/"+newFileName;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
        // 这里直接去src/main/resources/templates下找同名文件
    }
}
