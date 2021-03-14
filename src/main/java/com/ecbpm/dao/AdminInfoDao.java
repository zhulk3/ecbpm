package com.ecbpm.dao;

import com.ecbpm.pojo.AdminInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface AdminInfoDao {

    @Select("select * from admin_info where name = #{name} and pwd = #{pwd}")
    AdminInfo selectByNameAndPwd(AdminInfo adminInfo);

    @Select("select * from user_info where id = #{id}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "pwd", property = "pwd"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "fs", many = @Many(select = "com.ecbpm.dao.FunctionDao.selectByAdminId", fetchType = FetchType.EAGER))
    })
    AdminInfo selectById(int id);
}
