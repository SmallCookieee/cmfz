package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxl on 2018/7/12.
 */
public interface PermissionDao {
    public List<Permission> selectPermissionByManagerName(@Param("managerName")String managerName);
}
