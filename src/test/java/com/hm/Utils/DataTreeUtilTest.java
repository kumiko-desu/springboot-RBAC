package com.hm.Utils;

import com.hm.pojo.UserGroup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DataTreeUtilTest {
    @Test
    public void buildTreeWithoutRootTest(){
        List<UserGroup> userGroups= new ArrayList<>();
        UserGroup group = new UserGroup();
        group.setId(1);
        group.setName("重庆");
        group.setParentId(0);
        userGroups.add(group);
        group = new UserGroup();
        group.setId(2);
        group.setName("巴南区");
        group.setParentId(1);
        userGroups.add(group);
        group = new UserGroup();
        group.setId(3);
        group.setName("渝北区");
        group.setParentId(1);
        userGroups.add(group);
        group = new UserGroup();
        group.setId(4);
        group.setName("理工大学");
        group.setParentId(2);
        userGroups.add(group);

        Integer rootGroupId = 0;

        List<UserGroup> groups = DataTreeUtil.buildTreeWithoutRoot(userGroups, rootGroupId);

        System.out.println(groups);

    }
}
