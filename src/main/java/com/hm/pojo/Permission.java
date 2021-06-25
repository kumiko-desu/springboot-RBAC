package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Permission {

    private int id;

    private String name;

    private String code;

    private Date createdTime;
}
