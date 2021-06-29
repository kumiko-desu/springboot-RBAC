package com.hm.dao;

import com.hm.pojo.RoleMergeGroupItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMergeGroupItemMapper {

    @Select("select * from role_merge_group_item where group_id = #{groupId}")
    public List<RoleMergeGroupItem> getByGroupId(@Param("groupId") Integer groupId);

}
