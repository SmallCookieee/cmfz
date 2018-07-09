package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zxl on 2018/7/4.
 */
public interface ManagerDao {
    public Manager selectById(@Param("name") String name);

    public int insert(Manager manager);

}
