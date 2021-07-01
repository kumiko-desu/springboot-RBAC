package com.hm.controller;


import com.hm.pojo.Response;
import com.hm.service.RoleExclusionGroupItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class RoleExclusionGroupItemController {

    @Autowired
    RoleExclusionGroupItemService roleExclusionGroupItemService;

    @GetMapping("/exclusionGroupItem/del/{id}/{groupid}")
    public Response delete(@PathVariable("id") Integer id,
                            @PathVariable("groupid") Integer groupid){
        if(roleExclusionGroupItemService.delete(id,groupid)>0){
            return Response.success();
        }
        else
            return Response.fail();
    }

}
