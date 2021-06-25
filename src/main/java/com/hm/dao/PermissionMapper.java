package com.hm.dao;

import com.hm.pojo.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("select * from permission")
    List<Permission> findAllPermission();

    @Insert("insert into permission (name,code,created_time) value (#{permission.name},#{permission.code},#{permission.created_time,jdbcType=TIMESTAMP})")
    int InsertPermission(@Param("permission") Permission permission);

    @Delete("delete from permission where id=#{id}")
    int DeletePermissionById(@Param("id") Integer id);

    @Update("update permission set name=#{permission.name},code=#{permission.code} where id=#{id}")
    int UpdatePermission(@Param("permission") Permission permission);

    @Select("select * from permission limit #{start},#{size}")
    List<Permission> CurrentPage(@Param("start") int start,@Param("size") int size);
}
