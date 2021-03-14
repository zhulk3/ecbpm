package com.ecbpm.dao;

import com.ecbpm.dao.provider.UserInfoDynaSqlProvider;
import com.ecbpm.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    @Select("select * from user_info where status = 1")
    List<UserInfo> getValidUsers();

    @Select("select * from user_info where id = #{id}")
    UserInfo getUserInfoById(int id);

    @SelectProvider(type = UserInfoDynaSqlProvider.class, method = "selectWithParam")
    List<UserInfo> selectByPage(Map<String, Object> params);


    @SelectProvider(type = UserInfoDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Update("update user_info set status = #{flag} where id in (${ids})")
    void updateStatus(@Param("ids") String ids, @Param("flag") int flag);


}
