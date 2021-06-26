package com.hm.dao;

import com.hm.pojo.UserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserGroupMapper {

    @Select("select * from user_group")
    List<UserGroup> selectAll();

}
