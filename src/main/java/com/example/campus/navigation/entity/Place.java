package com.example.campus.navigation.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Place {
    private int pk_id;
    private String name;
    private String detail;
    private String latitude;
    private String longitude;
    private String picture;
    private String is_delete;
    private Date create_time;
    private Date update_time;
}
