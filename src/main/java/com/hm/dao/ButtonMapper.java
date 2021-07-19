package com.hm.dao;

import com.hm.pojo.Button;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ButtonMapper {

    @Select("select m.* from button m \n" +
            "LEFT JOIN permission_button p \n" +
            "on p.button_id=m.id \n" +
            "where p.permission_id = #{permissionId}")
    public List<Button> getByPermissionId(@Param("permissionId") Integer permissionId);

    @Select("select * from button")
    public List<Button> getAllButton();

    @Insert("insert into button(name,code) values (#{button.name} #{button.code})")
    public int insertInButton(@Param("button") Button button);

    @Delete("delete from button where id={#id}")
    public int deleteFromButton(@Param("id") Integer id);
}
