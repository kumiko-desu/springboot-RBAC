package com.hm.dao;

import com.hm.pojo.RoleMergeGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMergeGroupMapper {

    //根据 roleIds（即多个角色） 获取所有包含这些角色的RoleMergeGroup
    public List<RoleMergeGroup> getByRoleIds(@Param("roleIds") List<Integer> roleIds);

    //根据 groupId 和 roleIds ， 判断roleIds是否包括 group 中所有 role
    //为 0 则 满足，需要角色合并
    public int needMerge(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

}
