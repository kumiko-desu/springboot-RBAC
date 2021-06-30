package com.hm.dao;

import com.hm.pojo.Permission;
import com.hm.pojo.UserGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserGroupMapper {

    @Select("select * from user_group")
    public List<UserGroup> selectAll();

    @Insert("insert into user_group(name,parent_id,description) \n" +
            "values (#{userGroup.name},#{userGroup.parentId},#{userGroup.description}")
    public int add(@Param("userGroup") UserGroup userGroup);

    @Delete("delete from user_group where id=#{id}")
    public int DeleteById(@Param("id") Integer id);

    @Update("update user_group set name=#{userGroup.name},code=#{userGroup.parentId} where id=#{userGroup.id}")
    int Update(@Param("userGroup") UserGroup userGroup);
}
