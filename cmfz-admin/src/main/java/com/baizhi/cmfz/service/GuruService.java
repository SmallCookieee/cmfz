package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * Created by zxl on 2018/7/6.
 */
public interface GuruService {
    public int addGuru(Guru guru);

    public int modify(Guru guru);

    public Guru queryGuruById(String guruId);

    public Map<String,Object> queryGuruByName(String guruName,Integer nowPage, Integer pageSize);

    public Map<String,Object> queryAllGuru(Integer nowPage, Integer pageSize);

    public int addGurus(List<Guru> gurus);

    public List<Guru> queryGuru();
}
