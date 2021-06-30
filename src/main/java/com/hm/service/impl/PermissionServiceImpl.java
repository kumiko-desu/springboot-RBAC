package com.hm.service.impl;

import cn.hutool.core.date.DateUtil;
import com.hm.dao.PermissionMapper;
import com.hm.pojo.Permission;
import com.hm.pojo.Role;
import com.hm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermission() {
        List allPermission = permissionMapper.findAllPermission();
        System.out.println(allPermission);
        if(null!=allPermission){
            return allPermission;
        }
        return null;
    }

    @Override
    public List<Permission> findPermissionByRoleId(Integer id){
        return permissionMapper.getByRoleId(id);
    }


    @Override
    public int InsertPermission(Permission permission){
        Date date3 = DateUtil.date(System.currentTimeMillis());
        permission.setCreatedTime(date3);
        return permissionMapper.InsertPermission(permission);
    }

    @Override
    public int DeletePermissionById(Integer id){
        return permissionMapper.DeletePermissionById(id);
    }

    @Override
    public int UpdatePermission(Permission permission){ return permissionMapper.UpdatePermission(permission); }

    @Override
    public List<Permission> CurrentPage(int start,int size){
        List CurrentPage=permissionMapper.CurrentPage(start,size);
        if(null!=CurrentPage){
            return CurrentPage;
        }
        return null;
    }
}
