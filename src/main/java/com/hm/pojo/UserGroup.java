package com.hm.pojo;

import com.hm.Utils.DataTree;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserGroup implements DataTree<UserGroup,Integer> {

    private Integer id;
    private String name;
    private Integer parentId;
    private String description;

    private List<UserGroup> children = new ArrayList<>();

    @Override
    public void setChildren(List<UserGroup> children) {
        this.children = children;
    }

    @Override
    public List<UserGroup> getChildren() {
        return this.children;
    }

}
