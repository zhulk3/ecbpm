package com.ecbpm.service.impl;

import com.ecbpm.dao.AdminInfoDao;
import com.ecbpm.pojo.AdminInfo;
import com.ecbpm.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("adminInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoDao adminInfoDao;

    @Override
    public AdminInfo login(AdminInfo adminInfo) {
        return adminInfoDao.selectByNameAndPwd(adminInfo);
    }

    @Override
    public AdminInfo getAdminInfoAndFunctions(Integer id) {
        return adminInfoDao.selectById(id);
    }
}
