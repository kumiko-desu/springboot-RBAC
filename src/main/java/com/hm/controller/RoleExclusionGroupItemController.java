package com.hm.controller;


import com.hm.pojo.Response;
import com.hm.service.RoleExclusionGroupItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleExclusionGroupItemController {

    @Autowired
    RoleExclusionGroupItemService roleExclusionGroupItemService;

    @GetMapping("/exclusionGroupItem/del/{id}")
    public Response delete(@PathVariable("id") Integer id){
        if(roleExclusionGroupItemService.delete(id)>0){
            return Response.success();
        }
        else
            return Response.fail();
    }

}
