package com.hm.service;

import com.hm.pojo.Menu;
import com.hm.pojo.User;

import java.util.List;

public interface MenuService {

    // 获取用户对应的菜单树 (从 redis 缓存中)
    public List<Menu> getTreeByUser(User user);

    // 获取所有菜单
    public List<Menu> getTree();

    //获取所有菜单(非树)
    public List<Menu> getMenu();

    public int addMenu(Menu menu);
}
