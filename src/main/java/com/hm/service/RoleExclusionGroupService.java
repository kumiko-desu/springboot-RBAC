package com.hm.service;

import com.hm.pojo.RoleExclusionGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleExclusionGroupService {

    List<RoleExclusionGroup> getExclusionGroup();

}
