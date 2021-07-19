package com.hm.dao;

import com.hm.pojo.RoleMergeGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMergeGroupMapper {

    //根据 roleIds（即多个角色） 获取所有包含这些角色的RoleMergeGroup
    public List<RoleMergeGroup> getByRoleIds(@Param("roleIds") List<Integer> roleIds);

    //根据 groupId 和 roleIds ， 判断roleIds是否包括 group 中所有 role
    //为 0 则 满足，需要角色合并
    public int needMerge(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

    @Select("select * from role_merge_group")
    public List<RoleMergeGroup> get();

    @Insert("insert into role_merge_group(name, code) \n" +
            "values (#{group.name}, #{group.code})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int add(@Param("group") RoleMergeGroup group);

    @Delete("delete role_merge_group,role_merge_group_item from role_merge_group_item \n" +
            "left join role_merge_group\n" +
            "on role_merge_group_item.group_id = role_merge_group.id\n" +
            "where role_merge_group.id = #{groupId}")
    public int del(@Param("groupId") Integer groupId);

}
