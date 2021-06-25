package com.hm.dao;

import com.hm.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role")
    public List<Role> selectRole();

    @Delete("delete from role where id = #{id}")
    public int deleteRole(@Param("id") int id);

    @Insert("insert into role values (#{Role.name} #{Role.code} #{Role.createdTime} #{Role.maxCount} #{Role.useCount})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insertRole(@Param("Role") Role role);
}
