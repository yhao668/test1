package com.xxxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {


    @RequestMapping("fileUpload.do")
    public String sayHello(@RequestParam("myFile") MultipartFile file, HttpServletRequest req) {

        if (!file.isEmpty()) {
            //获取目标文件的真实路径
            String realPath = req.getServletContext().getRealPath("/");
            //构建一个文件对象
            File srcFile = new File(realPath,"/upload");
            //创建目录
            if (!srcFile.exists()) {
                //若没有目录创建目录
                srcFile.mkdirs();
            }
            //获取文件名称
            String fileName = file.getOriginalFilename();
            //获取文件hello.jpg
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //目标文件名称
            String fileName02 = System.currentTimeMillis() + suffix;
            try {
                //上传操作
                file.transferTo(new File(srcFile,fileName02));
                //存储信息
                req.setAttribute("msg", "上传成功了");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件上传失败");
                req.setAttribute("msg", "上传失败了");
            }
        } else {
            //System.out.println("文件不存在...");
            req.setAttribute("msg","文件不存在");
        }
        //
        return "result";

    }

    @RequestMapping("one.do")
    public String sayParam(@RequestParam("abc") String name, Model model) {
        model.addAttribute("msg", name);
        return "index";
    }

//    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
//    public String sayUpload(@RequestParam(value = "myFile",required = false) MultipartFile file,HttpServletRequest req){
//        System.out.println(file.getOriginalFilename()+"<<<<");
//        //判断是否为空
//        if(!file.isEmpty()){
//            //获取文件目录真实路径
//            String realPath = req.getServletContext().getRealPath("/");
//            //构建路径目录
//            // 文件存放服务端的位置
//
//            // 写文件到服务器
//            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
//            //获取文件名称
//            String originalFilename = file.getOriginalFilename();
//            //后缀
//            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//            //构建文件名称
//           String fileName= System.currentTimeMillis()+suffix;
//           //上传
//            try {
//                file.transferTo(new File(serverFile,fileName));
//            } catch (IOException e) {
//                e.printStackTrace();
//                //删除失败了
//                req.setAttribute("msg","上传文件失败了");
//            }
//
//        }else{
//            //若为空
//            req.setAttribute("msg","文件不存在");
//        }
//
//        return "result";
//    }
}
