package com.hm.service;

import com.hm.pojo.RoleExclusionGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleExclusionGroupService {

    List<RoleExclusionGroup> getExclusionGroup();

    int add(RoleExclusionGroup group, List<Integer> roleIds);

    int del(Integer groupId);

}
