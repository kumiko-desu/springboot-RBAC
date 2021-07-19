package com.hm.controller;

import com.hm.pojo.Permission;
import com.hm.pojo.Response;
import com.hm.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PermissionController {

    @Autowired
    PermissionServiceImpl permissionService;

    @GetMapping("/api/getAllPermissions")
    public Response<List<Permission>> getAllPermission(){
        List<Permission> allPermissions = permissionService.findAllPermission();
        if(allPermissions!=null){
            return Response.success(allPermissions);
        }else{
            return Response.fail("get allPermissions failed");
        }
    }

    @GetMapping("/api/getPermissionsByRoleId/{id}")
    public Response<List<Permission>> getPermissionsByRoleId(@PathVariable("id") Integer id){
        List<Permission> allPermissions = permissionService.findPermissionByRoleId(id);
        if(allPermissions!=null){
            return Response.success(allPermissions);
        }else{
            return Response.fail("get allPermissions failed");
        }
    }

    @PostMapping("/api/InsertPermission")
    public Response<String> InsertPermission(@RequestBody Permission permission){
        int save= permissionService.InsertPermission(permission);
        if(save>0){
            return Response.success("insert permission success!");
        }else{
            return Response.fail("insert permission fail!");
        }
    }
}
