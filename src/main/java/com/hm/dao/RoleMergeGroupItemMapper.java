package com.hm.dao;

import com.hm.pojo.RoleMergeGroupItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMergeGroupItemMapper {

    @Select("select * from role_merge_group_item where group_id = #{groupId}")
    public List<RoleMergeGroupItem> getByGroupId(@Param("groupId") Integer groupId);

    @Insert("insert into role_merge_group_item (group_id, role_id) values(#{groupId}, #{roleId})")
    public int add(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

}
