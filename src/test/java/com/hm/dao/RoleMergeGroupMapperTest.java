package com.hm.dao;

import com.hm.pojo.Role;
import com.hm.pojo.RoleMergeGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class RoleMergeGroupMapperTest {

    @Autowired
    RoleMergeGroupMapper roleMergeGroupMapper;

    @Autowired
    RoleMapper roleMapper;

    //测试 foreach xml
    @Test
    public void roleMergeGroupMapperTest(){

        List<Role> roles = roleMapper.getRoleByUserId(1);

//        List<Integer> groupIds = roles.stream().map(item -> {
//            Integer bean = new Integer();
//            BeanUtils.copyProperties(item, bean);
//            return bean;
//        }).collect(Collectors.toList());
        List<Integer> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());

        System.out.println(roleMergeGroupMapper.getByRoleIds(roleIds));

        System.out.println(roleMergeGroupMapper.needMerge(1,roleIds));

    }

}
