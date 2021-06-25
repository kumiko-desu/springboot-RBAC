package com.hm.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserGroupServiceImplTest {

    @Autowired
    UserGroupServiceImpl userGroupService;

    @Test
    public void getUserGroupTreeTest(){
        System.out.println(userGroupService.getUserGroupTree());
    }
}
