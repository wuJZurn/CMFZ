package com.wu.cmfz.service;

import com.wu.cmfz.entity.Logger;

import java.util.Map;

/**
 * Created by wu on 2018/7/9.
 */
public interface LoggerService {
    public Map<String,Object> queryLogger(int totalSize, int pageIndex);
    public boolean insertLogger(Logger logger);
}
