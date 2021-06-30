package com.hm.dao;

import com.hm.pojo.User;
import com.hm.pojo.UserGroup;
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

    @Insert("insert into user(username, salt, password, name, sex, old, group_id, created_time, last_login_time) \n" +
            "values (#{user.username} #{user.password} #{user.salt} #{user.name} #{user.sex} #{user.old} #{user.groupId} #{user.createdTime} #{user.lastLoginTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insertOne(@Param("user") User user);

    @Delete("delete from user where id=#{id}")
    public int DeleteById(@Param("id") Integer id);

}
