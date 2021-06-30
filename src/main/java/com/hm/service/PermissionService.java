package com.hm.service;

import com.hm.pojo.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermission();

    List<Permission> findPermissionByRoleId(Integer id);

    int InsertPermission(Permission permission);

    int DeletePermissionById(Integer id);

    int UpdatePermission(Permission permission);

    List<Permission> CurrentPage(int start,int size);
}
