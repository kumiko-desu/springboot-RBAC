package com.hm.dao;

import com.hm.pojo.RoleExclusionGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleExclusionGroupMapper {

    //获取所有角色组
    @Select("select * from role_exclusion_group")
    public List<RoleExclusionGroup> getExclusionGroup();

    //根据 roleIds（即多个角色） 获取所有包含这些角色的 RoleExclusionGroup
    public List<RoleExclusionGroup> getByRoleIds(@Param("roleIds") List<Integer> roleIds);

    //根据 groupId 和 roleIds ， 判断roleIds是否包括 group 中 1 个以上 role
    //大于 1 则 roleIds 存在互斥角色
    public int exclusion(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

    @Insert("insert into role_exclusion_group(name, description) \n" +
            "values (#{group.name}, #{group.description})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int add(@Param("group") RoleExclusionGroup group);

    @Delete("delete role_exclusion_group,role_exclusion_group_item from role_exclusion_group_item \n" +
            "left join role_exclusion_group\n" +
            "on role_exclusion_group_item.group_id = role_exclusion_group.id\n" +
            "where role_exclusion_group.id = #{groupId}")
    public int del(@Param("groupId") Integer groupId);
}
