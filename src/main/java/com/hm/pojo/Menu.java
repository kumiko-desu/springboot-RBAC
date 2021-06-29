package com.hm.pojo;

import com.hm.Utils.DataTree;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu implements DataTree<Menu,Integer> {

    private Integer id;
    private String name;
    private String path;
    private Integer linkType;
    private String description;
    private Integer parentId;
    private Integer pageId;

    private List<Menu> children = new ArrayList<>();
    @Override
    public void setChildren(List<Menu> children) {
        this.children = children;
    }
    @Override
    public List<Menu> getChildren() {
        return this.children;
    }

}
