package com.hm.dao;

import com.hm.pojo.RoleExclusionGroupItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleExclusionGroupItemMapper {

    public int add(@Param("groupId") Integer groupId, @Param("roleIds") List<Integer> roleIds);

}
