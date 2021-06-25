package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.UserGroupService;
import com.hm.service.UserService;
import com.hm.serviceImpl.UserGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/group/user")
public class UserGroupController {

    @Autowired
    UserGroupServiceImpl userGroupService;

    @RequestMapping("/tree")
    public Response<List<User>> getUserGroupTree(){
        return Response.success(userGroupService.getUserGroupTree());
    }

}
