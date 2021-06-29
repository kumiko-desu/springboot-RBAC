package com.hm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Permission {

    private Integer id;

    private String name;

    private String code;

    private Date createdTime;

    private List<Menu> menus;

    private List<Button> buttons;
}
