package com.hm.dao;

import com.hm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where group_id = #{groupId}")
    public List<User> selectUserByGroupId(Integer groupId);

}
