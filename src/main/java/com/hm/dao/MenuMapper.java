package com.hm.dao;

import com.hm.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select m.* from menu m \n" +
            "LEFT JOIN permission_menu p \n" +
            "on p.menu_id=m.id \n" +
            "where p.permission_id = #{permissionId}")
    public List<Menu> getByPermissionId(@Param("permissionId") Integer permissionId);

}
