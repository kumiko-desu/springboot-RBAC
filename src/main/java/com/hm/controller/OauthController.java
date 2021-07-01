package com.hm.controller;

import com.hm.Utils.UserUtils;
import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.impl.LoginServiceImpl;
import com.hm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/oauth")
// 验证相关
public class OauthController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    public Response login(@RequestBody User user, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        if(username.isEmpty() || password.isEmpty()){
            return Response.fail("用户名或者密码不能为空");
        }
        //获取用户
        User userByName = userService.getByUserName(user.getUsername());
        if(userByName == null) return Response.fail("不存在的用户");
        //验证密码 计算哈希密码， 比较 数据库密码
        if (UserUtils.calcHashPwd(password, userByName.getSalt()).equals(userByName.getPassword())){
            loginService.login(userByName);
            session.setAttribute("user", userByName);
            return Response.success("登录成功");
        }
        return Response.fail("密码错误");
    }

}
