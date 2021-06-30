package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.RoleExclusionGroup;
import com.hm.service.RoleExclusionGroupService;
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
    RoleExclusionGroupService roleExclusionGroupService;

    @GetMapping("/getExclusionGroup")
    public Response<List<RoleExclusionGroup>> getExclusionGroup(){
        return Response.success(roleExclusionGroupService.getExclusionGroup());
    }

    @RequestMapping("/add")
    public Response add(@RequestBody RoleExclusionGroup group){
        roleExclusionGroupService.add(group, group.getRoleIds());
        return Response.success();
    }

}
