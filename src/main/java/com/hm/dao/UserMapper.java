package com.hm.dao;

import com.hm.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where username = #{userName}")
    public User selectByUserName(String username);

    @Select("select * from user where group_id = #{groupId}")
    public List<User> selectByGroupId(Integer groupId);

    @Insert("insert into user values (#{user.username} #{user.password} #{user.salt} #{user.name} #{user.sex} #{user.old} #{user.groupId} #{user.createdTime} #{user.lastLoginTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public Integer insertOne(@Param("user") User user);

}
