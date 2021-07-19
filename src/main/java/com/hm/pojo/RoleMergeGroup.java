package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleMergeGroup {

    private Integer id;
    private String name;
    private String code;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;

    private List<Integer> roleIds;

}
