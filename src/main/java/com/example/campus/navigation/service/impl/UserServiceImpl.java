package com.example.campus.navigation.service.impl;

import com.example.campus.navigation.domain.DO.UserDO;
import com.example.campus.navigation.domain.dto.ModifyUserDTO;
import com.example.campus.navigation.domain.dto.UserDTO;
import com.example.campus.navigation.mapper.UserMapper;
import com.example.campus.navigation.service.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public UserDO getUser(UserDTO userDTO) {
        UserDO userDO = userMapper.find(userDTO);

        return userDO;
    }

    @Override
    public Integer updateUser(ModifyUserDTO modifyUserDTO) {

        Integer code = userMapper.modify(modifyUserDTO);

        return  code;
    }
}
