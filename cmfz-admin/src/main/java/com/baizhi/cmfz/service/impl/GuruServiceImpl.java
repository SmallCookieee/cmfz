package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxl on 2018/7/6.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao gd;

    @Override
    public int addGuru(Guru guru) {
        return gd.insertGuru(guru);
    }

    @Override
    public int modify(Guru guru) {
        return gd.updateGuru(guru);
    }

    @Override
    public Guru queryGuruById(String guruId) {
        return gd.selectGuruById(guruId);
    }

    @Override
    public Map<String,Object> queryGuruByName(String guruName,Integer nowPage, Integer pageSize) {
        List<Guru> gurus = gd.selectGuruByName(guruName,(nowPage-1)*pageSize,pageSize);
        System.out.println(guruName+"===="+gurus);
        int count = gd.countt(guruName);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public Map<String, Object> queryAllGuru(Integer nowPage, Integer pageSize) {
        List<Guru> gurus = gd.selectAllGuru((nowPage-1)*pageSize,pageSize);
        int count = gd.count();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public int addGurus(List<Guru> gurus) {
        return gd.insertBatch(gurus);
    }

    @Override
    public List<Guru> queryGuru() {
        return gd.selectGuru();
    }
}
