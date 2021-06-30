package com.hm.service;

import com.hm.pojo.RoleMergeGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleMergeGroupService {

    List<RoleMergeGroup> getMergeGroup();

    int add(RoleMergeGroup group, List<Integer> roleIds);

    int del(Integer groupId);

}
