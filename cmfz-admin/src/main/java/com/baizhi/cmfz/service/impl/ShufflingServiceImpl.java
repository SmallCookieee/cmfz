package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ShufflingDao;
import com.baizhi.cmfz.entity.Shuffling;
import com.baizhi.cmfz.service.ShufflingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxl on 2018/7/5.
 */
@Service
@Transactional
public class ShufflingServiceImpl implements ShufflingService {

    @Autowired
    private ShufflingDao sd;

    @Override
    public int addPic(Shuffling shuffling) {
        return sd.insertPic(shuffling);
    }

    @Override
    public int removePic(String id) {
        return sd.deletePic(id);
    }

    @Override
    public int modifyPic(Shuffling shuffling) {
        return sd.updatePic(shuffling);
    }

    @Override
    public Shuffling queryPicById(String id) {
        return sd.selectPicById(id);
    }

    @Override
    public Map<String,Object> queryAllPic(Integer nowPage, Integer pageSize) {
        List<Shuffling> shufflings = sd.selectAllPic((nowPage-1)*pageSize,pageSize);
        int count = sd.count();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",count);
        map.put("rows",shufflings);
        return map;
    }
}
