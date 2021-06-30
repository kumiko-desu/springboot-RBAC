package com.hm.controller;

import com.hm.Utils.UserUtils;
import com.hm.pojo.Response;
import com.hm.pojo.User;
import com.hm.service.impl.RoleServiceImpl;
import com.hm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping("")
    public Response<List<User>> getUserListByGroupId(Integer groupId){
        return Response.success(userService.getByGroupId(groupId));
    }

    @RequestMapping("/add")
    public Response addUser(@RequestBody User user, Integer groupId, List<Integer> roleIds){
        // 判断空属性

        // 用户密码加密
        String salt = UserUtils.createSalt();
        user.setSalt(salt);
        user.setPassword(UserUtils.calcHashPwd(user.getPassword(), salt));
        // 判断 roleIds 是否满足条件
        if (!roleService.isInclude(roleIds) ||
            !roleService.isExclusion(groupId, roleIds))
            return Response.fail("角色冲突");
        // 新增用户
        userService.addUser(user,groupId,roleIds);
        return Response.success("新增成功");
    }

}
