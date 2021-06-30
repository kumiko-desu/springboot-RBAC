package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.pojo.UserGroup;
import com.hm.service.impl.UserGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/group/user")
public class UserGroupController {

    @Autowired
    UserGroupServiceImpl userGroupService;

    @RequestMapping("/tree")
    public Response<List<User>> getTree(){
        return Response.success(userGroupService.getTree());
    }

    @RequestMapping("/add")
    public Response addGroup(@RequestBody UserGroup userGroup){
        // TODO: 判断数据是否合理

        if (userGroupService.add(userGroup) != 0) return Response.success();
        return Response.fail();
    }

}
