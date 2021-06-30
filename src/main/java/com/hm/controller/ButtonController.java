package com.hm.controller;

import com.hm.pojo.Button;
import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.ButtonService;
import com.hm.service.impl.ButtonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/button")
public class ButtonController {

    @Autowired
    ButtonServiceImpl buttonService;

    @RequestMapping("/all")
    public Response<List<Button>> getAll(){
        return Response.success(buttonService.getAllButton());
    }

    @RequestMapping("")
    public Response<List<Button>> getByPermissionId(Integer permissionId){
        return Response.success(buttonService.getByPermissionId(permissionId));
    }

    @RequestMapping("/insert")
    public Response insertIntoButton(Button button){
        return Response.success(buttonService.insertIntoButton(button));
    }

    @RequestMapping("/delete")
    public Response deleteFromButton(Integer id){
        return Response.success(buttonService.deleteFromButton(id));
    }
}
