package com.ecbpm.service;

import com.ecbpm.pojo.Pager;
import com.ecbpm.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    List<UserInfo> getValidUser();

    UserInfo getUserInfoById(int id);

    List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager);

    Integer count(Map<String,Object>params);

    void modifyStatus(String ids,int flag);

}

