package com.hm.service;

import com.hm.App;
import com.hm.pojo.Role;
import com.hm.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = App.class)
public class RoleServiceImplTest {
    @Autowired
    RoleServiceImpl roleService;

    @Test
    public void roleTest(){
//        System.out.println(roleService.selectRole());

        List<Integer> roleIds = new ArrayList<>();
        //roleIds.add(1);
        List<Role> roleList = roleService.allowSelect(roleIds);
        System.out.println(roleList);
    }
}
