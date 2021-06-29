package com.hm.controller;

import com.hm.dao.RoleMapper;
import com.hm.pojo.Response;
import com.hm.service.RoleService;
import com.hm.pojo.Role;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    @GetMapping("/selectRole")
    public Response<List<Role>> selectRole(){
        System.out.println(roleService.selectRole());
        return Response.success(roleService.selectRole());
    }

    @GetMapping("/deleteRole/{id}")
    public Response deleteRole(@PathVariable("id") int id){
        if(roleService.deleteRole(id)==1)
            return Response.success();
        else
            return Response.fail();
    }

    @PostMapping("/insertRole")
    public Response insertRole(@RequestBody Role role){
//        System.out.println(role.da);
        System.out.println(role);
        if(roleService.insertRole(role)>0)
            return Response.success();
        else
            return Response.fail();
    }
}
