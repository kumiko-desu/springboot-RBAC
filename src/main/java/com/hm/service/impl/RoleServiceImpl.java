package com.hm.service.impl;

import com.hm.dao.RoleExclusionGroupMapper;
import com.hm.dao.RoleIncludeGroupMapper;
import com.hm.pojo.RoleIncludeGroup;
import com.hm.service.RoleService;
import com.hm.dao.RoleMapper;
import com.hm.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleIncludeGroupMapper roleIncludeGroupMapper;
    @Autowired
    RoleExclusionGroupMapper roleExclusionGroupMapper;

    @Override
    public Role selectById(Integer id){
        return roleMapper.selectById(id);
    }

    @Override
    public List<Role> selectRole(){
        return roleMapper.selectRole();
    }

    @Override
    public int deleteRole(int id){
        return roleMapper.deleteRole(id);
    }

    @Override
    public int insertRole(Role role){
        Date date = new Date();
        role.setCreatedTime(date);
        return roleMapper.insertRole(role);
    }

    @Override
    public List<Role> selectByExclusionGroupId(Integer id){
        return roleMapper.selectByExclusionGroupId(id);
    }

    @Override
    public List<Role> selectByIncludeGroupId(Integer id){
        return roleMapper.selectByIncludeGroupId(id);
    }

    @Override
    public List<Role> selectByMergeGroupId(Integer id){
        return roleMapper.selectByMergeGroupId(id);
    }

    @Override
    public Boolean isInclude(List<Integer> roleIds) {
        for (Integer roleId : roleIds) {
            RoleIncludeGroup includeGroup = roleIncludeGroupMapper.getByRoleId(roleId);
            if (includeGroup == null) continue;
            Integer groupId = includeGroup.getId();
            // 1 为 (或 or)
            if(includeGroup.getType()){
                if (roleIncludeGroupMapper.includeOr(groupId, roleIds) == 0) return false;
            }else{ // 0 为 (且 and)
                if (roleIncludeGroupMapper.includeAnd(groupId, roleIds) != 0) return false;
            }
        }
        return true;
    }

    @Override
    public Boolean isExclusion(Integer groupId, List<Integer> roleIds) {
        if (roleExclusionGroupMapper.exclusion(groupId, roleIds) > 1) return false;
        return true;
    }

    @Override
    public List<Role> allowSelect(List<Integer> roleIds) {
        // 返回 role 列表 ( 先获取所有角色 )
        List<Role> roleList = roleMapper.selectRole();
        if(!roleIds.isEmpty()) {
            // 删除互斥角色
            roleList.removeAll(roleMapper.getRoleExclusion(roleIds));
            // 删除不满足先决条件的角色
            List<RoleIncludeGroup> includeGroups = roleIncludeGroupMapper.getByRoleIds(roleIds);
            for (RoleIncludeGroup includeGroup : includeGroups) {
                Integer groupId = includeGroup.getId();
                Integer roleId = includeGroup.getRoleId();
                // 1 为 (或 or)
                if(includeGroup.getType()){
                    if (roleIncludeGroupMapper.includeOr(groupId, roleIds) == 0)
                        roleList.removeIf(r -> r.getId() == roleId);
                }else{ // 0 为 (且 and)
                    if (roleIncludeGroupMapper.includeAnd(groupId, roleIds) != 0)
                        roleList.removeIf(r -> r.getId() == roleId);
                }
            }
        }
        return roleList;
    }


}
