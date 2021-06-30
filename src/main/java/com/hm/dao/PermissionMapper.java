package com.hm.dao;

import com.hm.pojo.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("select * from permission")
    List<Permission> findAllPermission();

    @Insert("insert into permission (name,code,created_time) value (#{permission.name},#{permission.code},#{permission.createdTime,jdbcType=TIMESTAMP})")
    int InsertPermission(@Param("permission") Permission permission);

    @Delete("delete from permission where id=#{id}")
    int DeletePermissionById(@Param("id") Integer id);

    @Update("update permission set name=#{permission.name},code=#{permission.code} where id=#{permission.id}")
    int UpdatePermission(@Param("permission") Permission permission);

    @Select("select * from permission limit #{start},#{size}")
    List<Permission> CurrentPage(@Param("start") int start,@Param("size") int size);

    //根据 roleId 获取 角色对应的 所有权限
    @Select("select p.* from permission p \n" +
            "LEFT JOIN role_permission rp on rp.permission_id = p.id \n" +
            "where rp.role_id = #{roleId}\n")
    List<Permission> getByRoleId(@Param("roleId") Integer roleId);

}
