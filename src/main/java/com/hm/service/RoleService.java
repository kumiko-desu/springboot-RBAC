package com.hm.service;

import com.hm.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    public List<Role> selectRole();

    public int deleteRole(int id);

    public int insertRole(Role role);

    // 判断 roleIds 是否满足 先决条件
    public Boolean isInclude(List<Integer> roleIds);

}
