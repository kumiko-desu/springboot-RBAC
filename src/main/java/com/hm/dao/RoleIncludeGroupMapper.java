package com.hm.dao;

import com.hm.pojo.RoleIncludeGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleIncludeGroupMapper {

    @Select("select * from role_include_group where role_id = #{roleId}")
    public RoleIncludeGroup getByRoleId(@Param("roleId") Integer roleId);

    // 根据 roleIds（即多个角色） 获取所有包含这些角色的 RoleIncludeGroup
    public List<RoleIncludeGroup> getByRoleIds(@Param("roleIds") List<Integer> roleIds);

    // 根据 groupId 和 roleIds ， 判断roleIds是否包括 group 中所有 role
    // and 时 做的判断， 计算group包含个数与group总个数之差， 为 0 则满足先决条件
    public int includeAnd(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

    // or 时 做的判断， 计算group包含多少个， 大于 0 则满足先决条件
    public int includeOr(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

}
