package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date lastLoginTime;

    private List<Integer> roleIds;
}
