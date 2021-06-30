package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.RoleExclusionGroup;
import com.hm.service.RoleExclusionGroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleExclusionGroupController {

    @Autowired
    RoleExclusionGroupService roleExclusionGroupService;

    @GetMapping("/getExclusionGroup")
    public Response<List<RoleExclusionGroup>> getExclusionGroup(){
        return Response.success(roleExclusionGroupService.getExclusionGroup());
    };

}
