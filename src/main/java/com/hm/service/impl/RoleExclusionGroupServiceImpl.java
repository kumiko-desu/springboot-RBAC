package com.hm.service.impl;

import com.hm.dao.RoleExclusionGroupItemMapper;
import com.hm.dao.RoleExclusionGroupMapper;
import com.hm.pojo.RoleExclusionGroup;
import com.hm.service.RoleExclusionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleExclusionGroupServiceImpl implements RoleExclusionGroupService {

    @Autowired
    RoleExclusionGroupMapper roleExclusionGroupMapper;
    @Autowired
    RoleExclusionGroupItemMapper roleExclusionGroupItemMapper;


    @Override
    public List<RoleExclusionGroup> getExclusionGroup(){
        return roleExclusionGroupMapper.getExclusionGroup();
    }

    @Override
    public int add(RoleExclusionGroup group, List<Integer> roleIds) {
        roleExclusionGroupMapper.add(group);
        Integer groupId = group.getId();
        for (Integer roleId : roleIds) {
            roleExclusionGroupItemMapper.add(groupId, roleId);
        }
        return 1;
    }

    @Override
    public int del(Integer groupId) {
        return roleExclusionGroupMapper.del(groupId);
    }

}
