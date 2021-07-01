package com.hm.controller;

import com.hm.pojo.Menu;
import com.hm.pojo.Response;
import com.hm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/tree")
    public Response<List<Menu>> getTree(){
        return Response.success(menuService.getTree());
    }



}
