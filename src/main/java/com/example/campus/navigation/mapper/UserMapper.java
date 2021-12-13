package com.example.campus.navigation.mapper;

import com.example.campus.navigation.domain.DO.UserDO;
import com.example.campus.navigation.domain.dto.ModifyUserDTO;
import com.example.campus.navigation.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDO find(UserDTO userDTO);

    Integer modify(ModifyUserDTO modifyUserDTO);



}
