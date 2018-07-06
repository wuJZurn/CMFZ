package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
public interface PictureDao {

    public List<Picture> selectAllPic(@Param("begin") int begin, @Param("showSize") int showSize);
    public int countPic();
    public Picture selectPicById(String picId);
    public boolean updatePic(Picture picture);
    public boolean insertPic(Picture picture);
    public boolean deletePic(Picture picture);
}
