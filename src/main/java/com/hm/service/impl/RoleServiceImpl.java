package com.hm.service.impl;

import com.hm.dao.RoleIncludeGroupItemMapper;
import com.hm.dao.RoleIncludeGroupMapper;
import com.hm.pojo.RoleIncludeGroup;
import com.hm.pojo.RoleIncludeGroupItem;
import com.hm.service.RoleService;
import com.hm.dao.RoleMapper;
import com.hm.pojo.Role;
import com.hm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleIncludeGroupItemMapper roleIncludeGroupItemMapper;
    @Autowired
    RoleIncludeGroupMapper roleIncludeGroupMapper;

    @Override
    public List<Role> selectRole(){
        return roleMapper.selectRole();
    }

    @Override
    public int deleteRole(int id){
        return roleMapper.deleteRole(id);
    }

    @Override
    public int insertRole(Role role){
        Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        role.setCreatedTime(t);
        return roleMapper.insertRole(role);
    }

    @Override
    public Boolean isInclude(List<Integer> roleIds) {
        for (Integer roleId : roleIds) {
            RoleIncludeGroup includeGroup = roleIncludeGroupMapper.getByRoleId(roleId);
            Integer groupId = includeGroup.getId();
            // 1 为 (或 or)
            if(includeGroup.getType()){
                if (roleIncludeGroupMapper.includeOr(groupId, roleIds) == 0) return false;
            }else{ // 0 为 (且 and)
                if (roleIncludeGroupMapper.includeAnd(groupId, roleIds) != 0) return false;
            }
        }
        return true;
    }


}
