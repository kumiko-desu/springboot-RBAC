package com.hm.service.impl;

import com.hm.dao.RoleMergeGroupItemMapper;
import com.hm.dao.RoleMergeGroupMapper;
import com.hm.pojo.RoleMergeGroup;
import com.hm.service.RoleMergeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMergeGroupServiceImpl implements RoleMergeGroupService {

    @Autowired
    RoleMergeGroupMapper roleMergeGroupMapper;
    @Autowired
    RoleMergeGroupItemMapper roleMergeGroupItemMapper;


    @Override
    public List<RoleMergeGroup> getMergeGroup(){
        return roleMergeGroupMapper.get();
    }

    @Override
    public int add(RoleMergeGroup group, List<Integer> roleIds) {
        roleMergeGroupMapper.add(group);
        Integer groupId = group.getId();
        for (Integer roleId : roleIds) {
            roleMergeGroupItemMapper.add(groupId, roleId);
        }
        return 1;
    }

    @Override
    public int del(Integer groupId) {
        return roleMergeGroupMapper.del(groupId);
    }

}
