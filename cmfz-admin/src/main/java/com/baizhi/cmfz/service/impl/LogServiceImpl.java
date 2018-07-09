package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxl on 2018/7/9.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;
    @Override
    public Map<String, Object> queryAllLog(Integer nowPage, Integer pageSize) {
        List<Log> logs = ld.selectAllLog((nowPage-1)*pageSize,pageSize);
        int count = ld.count();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }

    @Override
    public int addLog(Log log) {
        return ld.insertLog(log);
    }
}
