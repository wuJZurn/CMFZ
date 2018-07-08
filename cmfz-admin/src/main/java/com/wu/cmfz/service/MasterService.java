package com.wu.cmfz.service;

import com.wu.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/6.
 */
public interface MasterService {
    public Map<String,Object> queryMaster(int totalSize, int pageIndex,String sele,String masterName);
    public List<Master> queryAllMaster();
    public boolean addMaster(Master master);
    public boolean modifyMaster(Master master);

    public boolean addAllMaster(List<Master> list);
}
