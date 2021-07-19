package com.hm.service.impl;

import com.hm.Utils.DataTreeUtil;
import com.hm.dao.UserGroupMapper;
import com.hm.pojo.UserGroup;
import com.hm.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    UserGroupMapper userGroupMapper;

    /**
        * @return java.util.List<com.hm.pojo.UserGroup>
        * @date 2021/6/25 9:19
        * @description 返回用户组树形结构体
    */
    @Override
    public List<UserGroup> getTree() {
        List<UserGroup> userGroups = userGroupMapper.selectAll();
        if(userGroups.size() > 0){
            //设置用户组根Id为0
            Integer rootGroupId = 0;
            return DataTreeUtil.buildTreeWithoutRoot(userGroups, rootGroupId);
        }
        return new ArrayList<>();
    }
    
    @Override
    public int add(UserGroup userGroup){
        return userGroupMapper.add(userGroup);
    }
}
