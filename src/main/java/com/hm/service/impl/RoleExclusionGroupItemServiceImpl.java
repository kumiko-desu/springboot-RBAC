package com.hm.service.impl;


import com.hm.dao.RoleExclusionGroupItemMapper;
import com.hm.service.RoleExclusionGroupItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleExclusionGroupItemServiceImpl implements RoleExclusionGroupItemService {

    @Autowired
    RoleExclusionGroupItemMapper roleExclusionGroupItemMapper;

    @Override
    public int delete(Integer id,Integer groupid){
        return roleExclusionGroupItemMapper.delete(id,groupid);
    }

}
