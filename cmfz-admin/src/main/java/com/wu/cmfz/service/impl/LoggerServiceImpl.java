package com.wu.cmfz.service.impl;

import com.wu.cmfz.dao.LoggerDao;
import com.wu.cmfz.entity.Logger;
import com.wu.cmfz.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/9.
 */
@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerDao loggerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryLogger(int totalSize, int pageIndex) {
        List<Logger> loggers = loggerDao.selectLogger((pageIndex - 1) * totalSize, totalSize);
        int i = loggerDao.countLogger();
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",loggers);
        return map;
    }

    @Override
    public boolean insertLogger(Logger logger) {
        return loggerDao.insertLogger(logger);
    }
}
