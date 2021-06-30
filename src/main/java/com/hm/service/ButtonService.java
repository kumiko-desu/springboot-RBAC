package com.hm.service;

import com.hm.pojo.Button;

import java.util.List;

public interface ButtonService {

    public List<Button> getByPermissionId(Integer permissionId);

    public List<Button> getAllButton();

    public int insertIntoButton(Button button);

    public int deleteFromButton(Integer id);

}
