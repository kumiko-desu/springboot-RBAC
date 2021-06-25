package com.hm.dao;

import com.hm.pojo.UserGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserGroupMapper {

    List<UserGroup> selectUserGroup();

}
