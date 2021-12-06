package com.example.campus.navigation.entity;

import lombok.Data;

import java.sql.Date;
@Data
public class User {
    private int pk_id;
    private String name;
    private int age;
    private String avatar;
    private String grade;
    private String department;
    private String phone;
    private String dormitory;
    private String marker;
    private Integer is_delete;
    private Date update_time;
    private Date create_time;
}
