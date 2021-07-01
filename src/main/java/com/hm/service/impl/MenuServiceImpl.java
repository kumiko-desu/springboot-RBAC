package com.hm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.Utils.DataTreeUtil;
import com.hm.dao.MenuMapper;
import com.hm.pojo.*;
import com.hm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getTreeByUser(User user) {
        // 获取当前登录人的权限
        String key = "USER_" + user.getId();
        List<Object> values = stringRedisTemplate.boundHashOps(key).values();
        String roleJson = (String) values.get(2);
        Role role = null;
        try {
            role = objectMapper.readValue(roleJson, Role.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<Permission> permissions = role.getPermissions();
        // menu set
        Set<Menu> menuSet = new HashSet<>();
        for (Permission permission : permissions) {
            // 菜单合并
            menuSet.addAll(permission.getMenus());
        }
        if(menuSet.size() > 0){
            // Set 转 List
            List<Menu> menuList= new ArrayList<>(menuSet);
            // 设置用户组根Id为0
            Integer rootMenuId = 0;
            return DataTreeUtil.buildTreeWithoutRoot(menuList, rootMenuId);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Menu> getTree() {
        List<Menu> menus = menuMapper.selectAll();
        if (menus.size() > 0){
            Integer rootMenuId = 0;
            return DataTreeUtil.buildTreeWithoutRoot(menus, rootMenuId);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Menu> getMenu(){
        return menuMapper.getMenu();
    }

    @Override
    public int addMenu(Menu menu){
        menu.setLinkType(0);
        return menuMapper.addMenu(menu);
    }
}
