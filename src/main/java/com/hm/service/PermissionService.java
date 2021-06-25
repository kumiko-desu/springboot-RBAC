package com.hm.service;

import com.hm.pojo.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermission();

    int InsertPermission(Permission permission);

    int DeletePermissionById(Integer id);

    int UpdatePermission(Permission permission);

    List<Permission> CurrentPage(int start,int size);
}
