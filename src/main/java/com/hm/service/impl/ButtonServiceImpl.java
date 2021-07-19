package com.hm.service.impl;

import com.hm.dao.ButtonMapper;
import com.hm.pojo.Button;
import com.hm.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButtonServiceImpl implements ButtonService {

    @Autowired
    ButtonMapper buttonMapper;

    @Override
    public List<Button> getByPermissionId(Integer permissionId){
        return buttonMapper.getByPermissionId(permissionId);
    }

    @Override
    public List<Button> getAllButton() {
        return buttonMapper.getAllButton();
    }

    @Override
    public int insertIntoButton(Button button) {
        return buttonMapper.insertInButton(button);
    }

    @Override
    public int deleteFromButton(Integer id){
        return buttonMapper.deleteFromButton(id);
    }
}
