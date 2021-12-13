package com.example.campus.navigation.controller;

import com.example.campus.navigation.domain.dto.ModifyUserDTO;
import com.example.campus.navigation.domain.dto.UserDTO;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import com.example.campus.navigation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("/query")
    public RestResult getUser(@RequestBody UserDTO userDTO) {

        return new RestResultBuilder<>().success(userService.getUser(userDTO));

    }
    @PostMapping("/update")
    public RestResult updateUser(@RequestBody ModifyUserDTO modifyUserDTO) {

        return new RestResultBuilder<>().success(userService.updateUser(modifyUserDTO));

    }


}
