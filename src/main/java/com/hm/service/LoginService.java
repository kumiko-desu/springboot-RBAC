package com.hm.service;

import com.hm.pojo.Role;
import com.hm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    public void login(User user);

    // 获取用户对应的 所有角色 及其 对应的权限、菜单、按钮信息
    public List<Role> getRoles(User user);

}
