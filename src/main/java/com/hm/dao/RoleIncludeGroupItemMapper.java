package com.hm.dao;

import com.hm.pojo.RoleIncludeGroupItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleIncludeGroupItemMapper {

    @Select("select * from role_include_group_item where group_id = #{groupId}")
    public List<RoleIncludeGroupItem> getByGroupId(@Param("groupId") Integer groupId);

    @Select("select * from role_include_group_item\n" +
            "where group_id =\n" +
            "(select group_id from role_include_group\n" +
            "where role_id = #{roleId})")
    public List<RoleIncludeGroupItem> getByRoleId(@Param("roleId") Integer roleId);

    @Insert("insert into role_include_group_item (group_id, role_id) values(#{groupId}, #{roleId})")
    public int add(Integer groupId, Integer roleId);


}
