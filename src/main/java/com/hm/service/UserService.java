package com.hm.service;

import com.hm.pojo.Role;
import com.hm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> selectAll();

    public List<User> getByGroupId(Integer groupId);

    public User getByUserName(String userName);

    public void addUser(User user);

}
