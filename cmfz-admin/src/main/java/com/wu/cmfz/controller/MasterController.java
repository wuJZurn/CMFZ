package com.wu.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.wu.cmfz.entity.Master;
import com.wu.cmfz.service.MasterService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wu on 2018/7/6.
 */

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @RequestMapping("/showMaster")
    @ResponseBody
    public Map<String,Object> getMaster(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex,String sele,String seleName){
        if(seleName!=""&&seleName!=null){
            sele="true";
        }
        Map<String, Object> map = masterService.queryMaster(totalSize, pageIndex, sele, seleName);
        return map;
    }

    @RequestMapping("/addMaster")
    @ResponseBody
    public String addMaster(Master master,MultipartFile masterFile,HttpSession session) throws IOException {
        String realPath=session.getServletContext().getRealPath("").replace("admin","upload/master");
        String oldName = masterFile.getOriginalFilename();
        File dir = new File(realPath,oldName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        masterFile.transferTo(dir);
        master.setMasterPhoto("/"+oldName);
        boolean b = masterService.addMaster(master);
        if(b){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/modifyMaster")
    @ResponseBody
    public String modifyMaster(Master master){
        boolean b = masterService.modifyMaster(master);
        if(b){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/importMaster")
    @ResponseBody
    public String importExcel(MultipartFile subfile, HttpServletRequest request){
        try {

            ImportParams params = new ImportParams();
            params.setHeadRows(1);
            params.setNeedSave(true);

            String path=request.getSession().getServletContext().getRealPath("");

            File f = new File(path+"/excel/"+subfile.getOriginalFilename());

            if(!f.exists()){
                try {
                    File dir = new File(path+"/excel/");
                    dir.mkdirs();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            subfile.transferTo(f);
            List<Master> masters = ExcelImportUtil.importExcel(f,Master.class, params);
            for (Master master : masters) {
                master.setMasterPhoto(null);
                masterService.addMaster(master);
            }
            if(masters.isEmpty()){
               return "false";
            }
            System.out.println(JSON.toJSONString(masters));
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "false";
    }


}
