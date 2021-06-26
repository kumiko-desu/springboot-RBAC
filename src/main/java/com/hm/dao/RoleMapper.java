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

    //获取用户所有拥有的角色（包括 角色 和 所在角色组中的角色）
    @Select("select r.* from role r \n" +
            "left join user_role ur on ur.role_id=r.id \n" +
            "where ur.user_id = #{userId}\n" +
            "union\n" +
            "select * from role \n" +
            "where group_id in \n" +
            "(SELECT role_group_id from user_role_group \n" +
            "where user_id = #{userId})")
    public List<Role> getRoleByUserId(@Param("userId") Integer userId);
}
