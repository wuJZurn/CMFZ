package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Picture;
import com.wu.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wu on 2018/7/5.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/showPic")
    @ResponseBody
    public Map<String,Object> getPic(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){
        return pictureService.queryAllPic(totalSize,pageIndex);
    }

    @RequestMapping("/addPic")
    @ResponseBody
    public String addPic(Picture picture, MultipartFile myFile,HttpSession session) throws IOException {
        String realPath=session.getServletContext().getRealPath("").replace("admin","upload");
        String fileName= UUID.randomUUID().toString().replace("-","");
        String oldName = myFile.getOriginalFilename();
        File dir = new File(realPath,oldName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        myFile.transferTo(dir);
        Date date=new Date();
        picture.setPictureDate(date);
        picture.setPicturePath("/"+oldName);
        picture.setPictureId(fileName);
        boolean a=pictureService.addPic(picture);
        if(a){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/queryPicById")
    @ResponseBody
    public Picture queryPicById(String picId){
        Picture picture = pictureService.queryPicById(picId);
        return picture;
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public String updatePic(String pictureId,String pictureDescription,String pictureStatus,String picturePath){
        System.out.println("aaaa");
        boolean a = pictureService.modifyPic(new Picture(pictureId,picturePath,null,pictureDescription,pictureStatus));
        if(a){
            return "success";
        }
        return "false";
    }


}
