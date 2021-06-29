package com.hm.service.impl;

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

}
