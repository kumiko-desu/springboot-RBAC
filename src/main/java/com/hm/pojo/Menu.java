package com.hm.pojo;

import lombok.Data;

@Data
public class Menu {

    private Integer id;
    private String name;
    private String path;
    private Integer linkType;
    private String description;
    private Integer parentId;
    private Integer pageId;

}
