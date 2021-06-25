package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("")
    public Response<List<User>> getUserListByGroupId(Integer groupId){
        return Response.success(userService.getUserByGroupId(groupId));
    }

}
