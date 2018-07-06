package com.wu.cmfz.service;

import com.wu.cmfz.dao.PictureDao;
import com.wu.cmfz.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/5.
 */
public interface PictureService {

    public Map<String,Object> queryAllPic(int totalSize, int pageIndex);
    public Picture queryPicById(String id);
    public boolean addPic(Picture picture);
    public boolean modifyPic(Picture picture);
    public boolean removePic(Picture picture);
}
