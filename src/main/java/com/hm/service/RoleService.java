package com.hm.service;

import com.hm.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    public List<Role> selectRole();

    public int deleteRole(int id);

    public int insertRole(Role role);

}
