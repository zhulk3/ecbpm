package com.ecbpm.service;

import com.ecbpm.pojo.AdminInfo;

public interface AdminInfoService {
    AdminInfo login(AdminInfo adminInfo);

    AdminInfo getAdminInfoAndFunctions(Integer id);
}
