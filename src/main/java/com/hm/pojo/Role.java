package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;
    private String code;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private Integer maxCount;
    private Integer useCount;

    List<Permission> permissions;
}
