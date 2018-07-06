package com.wu.cmfz.service.impl;

import com.wu.cmfz.dao.MasterDao;
import com.wu.cmfz.entity.Master;
import com.wu.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/6.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao masterDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> queryMaster(int totalSize, int pageIndex,String sele, String seleName) {
        if(sele!=null){
           seleName="%"+seleName+"%";
        }
        List<Master> masters = masterDao.selectMaster((pageIndex - 1) * totalSize, totalSize, sele, seleName);
        int i = masterDao.countMaster(sele, seleName);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",masters);
        return map;
    }

    @Override
    public boolean addMaster(Master master) {
        return masterDao.insertMaster(master);
    }

    @Override
    public boolean modifyMaster(Master master) {
        return masterDao.updateMaster(master);
    }
}
