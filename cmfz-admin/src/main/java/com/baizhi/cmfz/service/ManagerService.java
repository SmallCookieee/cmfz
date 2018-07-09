package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by zxl on 2018/7/4.
 */
public interface ManagerService {

    public Manager login(String name, String password);

    public int insert(Manager manager);
}
