package com.hm.serviceImpl;

import com.hm.dao.UserMapper;
import com.hm.pojo.User;
import com.hm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
        * @return java.util.List<com.hm.pojo.User>
        * @date 2021/6/25 10:48
        * @description 根据groupId获取用户列表
    */
    @Override
    public List<User> getUserByGroupId(Integer groupId) {
        return userMapper.selectUserByGroupId(groupId);
    }
}
