package com.hm.serviceImpl;

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

    @Override
    public List<UserGroup> getUserGroupTree() {
        List<UserGroup> userGroups = userGroupMapper.selectUserGroup();
        if(userGroups.size() > 0){
            Integer rootGroupId = 0;
            return DataTreeUtil.buildTreeWithoutRoot(userGroups, rootGroupId);
        }
        return new ArrayList<>();
    }
}
