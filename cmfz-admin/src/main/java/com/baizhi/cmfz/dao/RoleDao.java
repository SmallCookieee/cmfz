package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxl on 2018/7/12.
 */
public interface RoleDao {
    public List<Role> selectRoleByManagerName(@Param("managerName")String managerName);
}
