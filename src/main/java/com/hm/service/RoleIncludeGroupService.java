package com.hm.service;

import com.hm.pojo.RoleIncludeGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleIncludeGroupService {

    List<RoleIncludeGroup> get();

    int add(RoleIncludeGroup group, List<Integer> roleIds);

    int del(Integer groupId);

}
