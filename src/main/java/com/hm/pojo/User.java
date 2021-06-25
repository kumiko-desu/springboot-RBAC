package com.hm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String salt;
    private Integer sex;
    private Integer old;
    private Integer groupId;
    private Date createdTime;
    private Date lastLoginTime;
}
