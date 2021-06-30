package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.RoleIncludeGroup;
import com.hm.service.RoleIncludeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/includeGroup")
public class RoleIncludeGroupController {

    @Autowired
    RoleIncludeGroupService roleIncludeGroupService;

    @GetMapping("/get")
    public Response<List<RoleIncludeGroup>> getIncludeGroup(){
        return Response.success(roleIncludeGroupService.get());
    }

    @RequestMapping("/add")
    public Response add(@RequestBody RoleIncludeGroup group){
        roleIncludeGroupService.add(group, group.getRoleIds());
        return Response.success();
    }

    @RequestMapping("del")
    public Response del(Integer groupId){
        roleIncludeGroupService.del(groupId);
        return Response.success();
    }

}
