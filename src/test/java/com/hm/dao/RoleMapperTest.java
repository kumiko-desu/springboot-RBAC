package com.hm.dao;

import com.hm.App;
import com.hm.dao.RoleMapper;
import com.hm.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void roleMapperTest(){
//        System.out.println(roleMapper.selectRole());
        System.out.println(roleMapper.getRoleByUserId(1));
    }
}
