package com.hm.dao;

import com.hm.pojo.UserGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserGroupMapper {

    @Select("select * from user_group")
    public List<UserGroup> selectAll();

    @Insert("insert into user_group(name,parent_id,description) \n" +
            "values (#{userGroup.name},#{userGroup.parentId},#{userGroup.description}")
    public Boolean add(@Param("userGroup") UserGroup userGroup);

}
