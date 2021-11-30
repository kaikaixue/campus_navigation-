package com.example.campus.navigation.domain.dto;

import lombok.Data;

@Data
public class ModifyUserDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String avatar;
    private String grade;
    private String department;
    private String phone;
    private String dormitory;
}
