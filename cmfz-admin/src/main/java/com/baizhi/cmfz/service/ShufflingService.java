package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Shuffling;

import java.util.Map;

/**
 * Created by zxl on 2018/7/5.
 */
public interface ShufflingService {
    public int addPic(Shuffling shuffling);

    public int removePic(String id);

    public int modifyPic(Shuffling shuffling);

    public Shuffling queryPicById(String id);

    public Map<String,Object> queryAllPic(Integer nowPage, Integer pageSize);
}
