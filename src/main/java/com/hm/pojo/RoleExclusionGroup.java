package com.hm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RoleExclusionGroup {

    private Integer id;
    private String name;
    private String description;

    private List<Integer> roleIds;
}
