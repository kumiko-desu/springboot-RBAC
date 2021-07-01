package com.hm.service.impl;

import com.hm.dao.UserMapper;
import com.hm.pojo.Role;
import com.hm.pojo.User;
import com.hm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    /**
        * @return java.util.List<com.hm.pojo.User>
        * @date 2021/6/25 10:48
        * @description 根据groupId获取用户列表
    */
    @Override
    public List<User> getByGroupId(Integer groupId) {
        return userMapper.selectByGroupId(groupId);
    }

    /**
        * @return com.hm.pojo.User
        * @date 2021/6/26 9:05
        * @description 根据用户名获取一个用户
    */
    @Override
    public User getByUserName(String username) {
        return userMapper.selectByUserName(username);
    }

    /**
        * @return void
        * @date 2021/6/29 17:27
        * @description 根据用户信息，用户组id，选择的角色id 新增用户
    */
    @Override
    public void addUser(User user) {
        user.setCreatedTime(new Date());
        userMapper.insertOne(user);
        userMapper.insertUserRole(user.getId(), user.getRoleIds());
    }
}
