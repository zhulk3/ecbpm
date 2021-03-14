package com.ecbpm.dao;

import com.ecbpm.pojo.Functions;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

public interface FunctionDao {

    @Select("select * from functions where id in(select fid from powers where aid = #{aid})")
    List<Functions> selectByAdminId(Integer aid);
}
