package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wu on 2018/7/6.
 */
public interface MasterDao {
      public List<Master> selectMaster(@Param("begin") int begin, @Param("showSize") int showSize, @Param("sele") String sele, @Param("masterName") String masterName);
      public int countMaster(@Param("sele") String sele,@Param("masterName") String masterName);
      public boolean updateMaster(Master master);
      public boolean deleteMaster(Master master);
      public boolean insertMaster(Master master);
}
