package com.hm.controller;

import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/oauth")
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public Response login(@RequestBody User user, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();

        if(username.isEmpty() || password.isEmpty()){
            return Response.fail("用户名或者密码不能为空");
        }

        //获取用户
        //验证密码

        return null;
    }

}
