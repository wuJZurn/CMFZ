package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Logger;
import org.apache.ibatis.annotations.Param;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Created by wu on 2018/7/9.
 */
public interface LoggerDao {
    public List<Logger> selectLogger(@Param("begin") int begin, @Param("showSize") int showSize);
    public int countLogger();
    public boolean insertLogger(Logger logger);
}
