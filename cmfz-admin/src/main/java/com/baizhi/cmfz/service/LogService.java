package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * Created by zxl on 2018/7/9.
 */
public interface LogService {
    public Map<String,Object> queryAllLog(Integer nowPage, Integer pageSize);

    public int insertLog(Log log);
}
