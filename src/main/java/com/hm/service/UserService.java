package com.hm.service;

import com.hm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getByGroupId(Integer groupId);

    public User getByUserName(String userName);

}
