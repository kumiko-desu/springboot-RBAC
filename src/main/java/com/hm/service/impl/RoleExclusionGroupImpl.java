package com.hm.service.impl;

import com.hm.dao.RoleExclusionGroupMapper;
import com.hm.pojo.RoleExclusionGroup;
import com.hm.service.RoleExclusionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleExclusionGroupImpl implements RoleExclusionGroupService {

    @Autowired
    RoleExclusionGroupMapper roleExclusionGroupMapper;


    @Override
    public List<RoleExclusionGroup> getExclusionGroup(){
        return roleExclusionGroupMapper.getExclusionGroup();
    }

}
