package com.hm.service;

import com.hm.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface RoleService {

    public Role selectById(Integer id);

    public List<Role> selectRole();

    public int deleteRole(int id);

    public int insertRole(Role role);

    public List<Role> selectByExclusionGroupId(Integer id);

    public List<Role> selectByIncludeGroupId(Integer id);

    public List<Role> selectByMergeGroupId(Integer id);

    // 判断 roleIds 是否满足 先决条件
    public Boolean isInclude(List<Integer> roleIds);
    // 判断 roleIds 是否满足 互斥条件
    public Boolean isExclusion(Integer groupId, List<Integer> roleIds);
    // 输入已选择的角色，返回可选的角色
    public List<Role> allowSelect(List<Integer> roleIds);

}
