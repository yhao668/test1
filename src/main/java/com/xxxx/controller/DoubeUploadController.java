package com.xxxx.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class DoubeUploadController {


    @RequestMapping(value = "dupload.do",method = RequestMethod.POST)
    public String sayUpload(@RequestParam("files") List<MultipartFile> file, HttpServletRequest req){
        //
        if(!file.isEmpty()){
            //上传
            //获取项目真实目录
            String realPath = req.getSession().getServletContext().getRealPath("/");
            File srcFile=new File(realPath,"/upload");
            //判断目录是否存在
            if(!srcFile.exists()){
                //创建目录以及父目录
                srcFile.mkdirs();
            }
            //获取文件名称
            //遍历
            for (MultipartFile ff:file
                 ) {
                //原文件名hello.txt
                String originalFilename = ff.getOriginalFilename();
                //获取文件名后缀
                String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
                //使用UUID作为文件名称的前缀
               String fileName= UUID.randomUUID().toString().replace("-","")+suffix;
                //上传
                try {
                    ff.transferTo(new File(srcFile,fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                    req.setAttribute("msg","上传失败了");
                }
            }
            req.setAttribute("msg","上传OK");
        }else{
            //提示
            req.setAttribute("msg","文件是空的");
        }
        return "result";
    }
}
