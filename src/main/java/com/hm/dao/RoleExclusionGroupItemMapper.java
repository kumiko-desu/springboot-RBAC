package com.hm.dao;

import com.hm.pojo.RoleExclusionGroupItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleExclusionGroupItemMapper {

    @Insert("insert into role_exclusion_group_item (group_id, role_id) values(#{groupId}, #{roleId})")
    public int add(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

    @Delete("delete from role_exclusion_group_item where role_id = #{id} and group_id= #{groupid}")
    public int delete(@Param("id") Integer id,@Param("groupid") Integer groupid);
}
