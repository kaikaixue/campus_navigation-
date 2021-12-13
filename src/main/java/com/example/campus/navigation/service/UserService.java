package com.example.campus.navigation.service;

import com.example.campus.navigation.domain.DO.UserDO;
import com.example.campus.navigation.domain.dto.ModifyUserDTO;
import com.example.campus.navigation.domain.dto.UserDTO;

public interface UserService {
    /**
     * 得到信息
     */
    UserDO getUser(UserDTO userDTO);

    /**
     * 修改信息
     */
    Integer updateUser(ModifyUserDTO modifyUserDTO);

}
