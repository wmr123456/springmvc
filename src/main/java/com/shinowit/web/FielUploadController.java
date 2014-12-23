package com.shinowit.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2014/12/22.
 */
@Controller
@RequestMapping(value = "/upload")
public class FielUploadController {
    @RequestMapping(value = "/fielupload")
    public String test(@RequestParam("aaaaaa") MultipartFile uploadfile,HttpServletRequest request){
        if(uploadfile.isEmpty()==true){
            return "redirect:/html/fielUpload.html";
        }
        System.out.println(uploadfile.getName());
        System.out.println(uploadfile.getSize());
        System.out.println(uploadfile.getContentType());
        String uri = request.getServletContext().getRealPath("/image");
        System.out.println(uri);
        String outputfielname= request.getServletContext().getRealPath("/image")+"/"+uploadfile.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(uploadfile.getInputStream(), new File(outputfielname));
            System.out.println(outputfielname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
