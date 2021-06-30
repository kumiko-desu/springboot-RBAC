package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.RoleMergeGroup;
import com.hm.service.RoleMergeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mergeGroup")
public class RoleMergeGroupController {

    @Autowired
    RoleMergeGroupService roleMergeGroupService;

    @GetMapping("/get")
    public Response<List<RoleMergeGroup>> getMergeGroup(){
        return Response.success(roleMergeGroupService.getMergeGroup());
    }

    @RequestMapping("/add")
    public Response add(@RequestBody RoleMergeGroup group){
        roleMergeGroupService.add(group, group.getRoleIds());
        return Response.success();
    }

}
