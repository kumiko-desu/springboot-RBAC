package com.hm.dao;

import com.hm.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role")
    public List<Role> selectRole();

    @Select("select * from role where id = #{id}")
    public Role selectById(Integer id);

    @Delete("delete from role where id = #{id}")
    public int deleteRole(@Param("id") int id);

    @Insert("insert into role(name,code,created_time,max_count,use_count) values (#{Role.name},#{Role.code},#{Role.createdTime},#{Role.maxCount},0)")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insertRole(@Param("Role") Role role);

    // 获取某个互斥组的所有角色
    @Select("select * from role \n" +
            "where id in \n" +
            "(select DISTINCT role_id from role_exclusion_group_item \n" +
            "where group_id = #{groupId})")
    public List<Role> selectByExclusionGroupId(@Param("groupId") Integer groupId);

    //获取某个先决组的所有角色
    @Select("select * from role \n" +
            "where id in \n" +
            "(select DISTINCT role_id from role_include_group_item \n" +
            "where group_id = #{groupId})")
    public List<Role> selectByIncludeGroupId(@Param("groupId") Integer groupId);

    //获取某个合并组的所有角色
    @Select("select * from role \n" +
            "where id in \n" +
            "(select DISTINCT role_id from role_merge_group_item \n" +
            "where group_id = #{groupId})")
    public List<Role> selectByMergeGroupId(@Param("groupId") Integer groupId);

    // 获取用户所有拥有的角色（包括 角色 和 所在角色组中的角色）
    @Select("select r.* from role r \n" +
            "left join user_role ur on ur.role_id=r.id \n" +
            "where ur.user_id = #{userId}\n" +
            "union\n" +
            "select * from role \n" +
            "where group_id in \n" +
            "(SELECT role_group_id from user_role_group \n" +
            "where user_id = #{userId})")
    public List<Role> getRoleByUserId(@Param("userId") Integer userId);
    // 获取所有与 roleIds 冲突的角色
    public List<Role> getRoleExclusion(@Param("roleIds") List<Integer> roleIds);
}
