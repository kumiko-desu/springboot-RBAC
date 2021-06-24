package com.hm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;
    private String name;
    private String code;
    private Date createdTime;
    private Integer maxCount;
    private Integer useCount;
}
