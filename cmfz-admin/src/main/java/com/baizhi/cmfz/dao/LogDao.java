package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxl on 2018/7/9.
 */
public interface LogDao {
    public List<Log> selectAllLog(@Param("begin") Integer begin,@Param("end") Integer end);

    public int count();

    public int insertLog(Log log);
}
