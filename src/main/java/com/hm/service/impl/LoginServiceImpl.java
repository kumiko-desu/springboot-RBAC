package com.hm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.dao.*;
import com.hm.pojo.*;
import com.hm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    ButtonMapper buttonMapper;
    @Autowired
    RoleMergeGroupMapper roleMergeGroupMapper;
    @Autowired
    RoleMergeGroupItemMapper roleMergeGroupItemMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void login(User user) {
        // 获取所有角色
        List<Role> roles = getRoles(user);
        String key = "USER_"+ user.getId();
        // redis缓存
        for (Role role : roles) {
            try {
                // 转换为json格式数据
                String roleJson = objectMapper.writeValueAsString(role);
                // 存入redis
                stringRedisTemplate.boundHashOps(key).put(role.getCode(), roleJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Role> getRoles(User user) {
        List<Role> roles = roleMapper.getRoleByUserId(user.getId());
        for (Role role : roles) {
            //获取角色对应的权限
            List<Permission> permissions = permissionMapper.getByRoleId(role.getId());
            for (Permission permission : permissions) {
                //获取权限对应的菜单和按钮
                Integer permissionId = permission.getId();
                permission.setMenus(menuMapper.getByPermissionId(permissionId));
                permission.setButtons(buttonMapper.getByPermissionId(permissionId));
            }
            role.setPermissions(permissions);
        }
        // 处理角色合并
        // 新的角色列表
        List<Role> newRoleList = new ArrayList<>();
        // 获得roleID列表
        List<Integer> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        // 查询可疑的合并组
        List<RoleMergeGroup> mergeGroups = roleMergeGroupMapper.getByRoleIds(roleIds);
        // 比对roles与组的id相匹配
        Set<Integer> mergedIds = new HashSet<>();//记录合并过的源角色
        // 对每个组进行判断
        for (RoleMergeGroup mergeGroup : mergeGroups) {
            // 等于0则可以合并
            if(roleMergeGroupMapper.needMerge(mergeGroup.getId(),roleIds)==0){
                // 根据合并组ID获取合并组的详细信息(item)
                List<RoleMergeGroupItem> mergeGroupItemList = roleMergeGroupItemMapper.getByGroupId(mergeGroup.getId());
                // roleMergeGroupItems 转换为 role
                Role role = new Role();
                role.setCode(mergeGroup.getCode());
                role.setName(mergeGroup.getName());
                // 获取合并组所有权限
                List<Permission> permissionList = new ArrayList<>();
                for (RoleMergeGroupItem roleMergeGroupItem : mergeGroupItemList) {
                    for (Role tempRole : roles) {
                        if(roleMergeGroupItem.getRoleId().equals(tempRole.getId())){
                            permissionList.addAll(tempRole.getPermissions());
                            // 记录合并过的角色
                            mergedIds.add(tempRole.getId());
                        }
                    }
                }
                role.setPermissions(permissionList);
                // 增加新角色(角色组)
                newRoleList.add(role);
            }
        }
        // 找出没有合并过的role添加到新role列表
        for (Role role : roles) {
            // roleId不在mergedIds内，未合并过
            if (!mergedIds.contains(role.getId())){
                newRoleList.add(role);
            }
        }
        return newRoleList;
    }


}
