package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RoleMergeGroupItem {

    private Integer id;
    private Integer roleId;
    private Integer groupId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;

}
