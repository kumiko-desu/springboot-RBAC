package com.hm.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserGroupMapperTest {

    @Autowired
    UserGroupMapper userGroupMapper;

    @Test
    public void selectUserGroup(){
        System.out.println(userGroupMapper.selectAll());
    }
}
