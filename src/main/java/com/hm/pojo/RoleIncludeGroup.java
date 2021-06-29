package com.hm.pojo;

import lombok.Data;

@Data
public class RoleIncludeGroup {

    private Integer id;
    private Integer roleId;
    private String name;
    private Boolean type;
    private String description;

}
