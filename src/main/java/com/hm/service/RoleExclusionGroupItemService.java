package com.hm.service;

import org.springframework.stereotype.Service;

@Service
public interface RoleExclusionGroupItemService {

    int delete(Integer id,Integer groupid);

}
