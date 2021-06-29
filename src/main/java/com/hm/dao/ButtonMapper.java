package com.hm.dao;

import com.hm.pojo.Button;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ButtonMapper {

    @Select("select m.* from button m \n" +
            "LEFT JOIN permission_button p \n" +
            "on p.button_id=m.id \n" +
            "where p.permission_id = #{permissionId}")
    public List<Button> getByPermissionId(@Param("permissionId") Integer permissionId);

}
