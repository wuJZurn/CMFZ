package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Master;
import com.wu.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    public String addMaster(Master master){
        boolean b = masterService.addMaster(master);
        if(b){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/modifyMaster")
    @ResponseBody
    public String modifyMaster(Master master){
        boolean b = masterService.addMaster(master);
        if(b){
            return "success";
        }
        return "false";
    }
}
