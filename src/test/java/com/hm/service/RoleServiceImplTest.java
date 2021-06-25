package com.hm.service;

import com.hm.App;
import com.hm.serviceImpl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
public class RoleServiceImplTest {
    @Autowired
    RoleServiceImpl roleService;

    @Test
    public void roleTest(){
        System.out.println(roleService.selectRole());

    }
}
