package com.hm.service.impl;

import com.hm.dao.RoleIncludeGroupItemMapper;
import com.hm.dao.RoleIncludeGroupMapper;
import com.hm.pojo.RoleIncludeGroup;
import com.hm.service.RoleIncludeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleIncludeGroupServiceImpl implements RoleIncludeGroupService {

    @Autowired
    RoleIncludeGroupMapper roleIncludeGroupMapper;
    @Autowired
    RoleIncludeGroupItemMapper roleIncludeGroupItemMapper;


    @Override
    public List<RoleIncludeGroup> get(){
        return roleIncludeGroupMapper.get();
    }

    @Override
    public int add(RoleIncludeGroup group, List<Integer> roleIds) {
        roleIncludeGroupMapper.add(group);
        Integer groupId = group.getId();
        for (Integer roleId : roleIds) {
            roleIncludeGroupItemMapper.add(groupId, roleId);
        }
        return 1;
    }

    @Override
    public int del(Integer groupId) {
        return roleIncludeGroupMapper.del(groupId);
    }

}
