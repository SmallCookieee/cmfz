package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zxl on 2018/7/4.
 */

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao md;

    @Override
    public Manager login(String name, String password) {
        Manager manager = md.selectById(name);
        if(manager!=null){
            String pwd = EncryptionUtil.encryption(password+manager.getSalt());
            String inpwd = EncryptionUtil.encryption(password+manager.getSalt());
            if(pwd.equals(inpwd)){
                return manager;
            }
        }
        return null;
    }

    @Override
    public int insert(Manager manager) {
        return md.insert(manager);
    }
}
