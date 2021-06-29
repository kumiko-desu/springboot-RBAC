package com.hm.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;
    private String code;
    private Date createTime;
    private Integer maxCount;
    private Integer useCount;

    List<Permission> permissions;
}
