package com.hm.controller;

import com.hm.pojo.Menu;
import com.hm.pojo.Response;
import com.hm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    public Response<List<Menu>> getMenu(){
        return Response.success(menuService.getMenu());
    }

    @PostMapping("/add")
    public Response addMenu(@RequestBody Menu menu){
        if(menuService.addMenu(menu)>0){
            return Response.success();
        }
        else
            return Response.fail();
    }
}
