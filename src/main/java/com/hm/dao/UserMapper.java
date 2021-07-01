package com.hm.dao;

import com.hm.pojo.User;
import com.hm.pojo.UserGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where username = #{username}")
    public User selectByUserName(@Param("username") String username);

    @Select("select * from user where group_id = #{groupId}")
    public List<User> selectByGroupId(Integer groupId);

    @Insert("insert into user(username, password, salt, name, sex, old, group_id, created_time) \n" +
            "values (#{user.username}, #{user.password}, #{user.salt}, #{user.name}, #{user.sex}, #{user.old}, #{user.groupId}, #{user.createdTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insertOne(@Param("user") User user);

    public int insertUserRole(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);

    @Delete("delete from user where id=#{id}")
    public int DeleteById(@Param("id") Integer id);

}
