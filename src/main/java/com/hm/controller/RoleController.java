package com.hm.controller;

import com.hm.dao.RoleMapper;
import com.hm.pojo.Response;
import com.hm.service.RoleService;
import com.hm.serviceImpl.RoleServiceImpl;
import com.hm.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleMapper roleMapper;

    @GetMapping("/selectRole")
    public Response<List<Role>> selectRole(){
        System.out.println(roleMapper.selectRole());
        return Response.success(roleService.selectRole());
    }

    @GetMapping("/deleteRole/{id}")
    public Response deleteRole(@PathVariable("id") int id){
        if(roleService.deleteRole(id)==1)
            return Response.success();
        else
            return Response.fail();
    }

    @GetMapping("/insertRole")
    public Response insertRole(@RequestBody Role role){
//        System.out.println(role.da);
        
        return Response.success();
    }
}
