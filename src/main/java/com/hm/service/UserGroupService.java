package com.hm.service;

import com.hm.pojo.UserGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserGroupService {

    public List<UserGroup> getTree();

    public int add(UserGroup userGroup);

}
