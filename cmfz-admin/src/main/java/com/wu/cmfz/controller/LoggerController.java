package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Logger;
import com.wu.cmfz.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/9.
 */
@Controller
@RequestMapping("/logger")
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @RequestMapping("/showLogger")
    @ResponseBody
    public Map<String,Object> showLogger(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){
        Map<String, Object> map = loggerService.queryLogger(totalSize, pageIndex);
        return map;
    }

}
