package com.example.campus.navigation.entity;

import lombok.Data;

import java.sql.Date;
@Data
public class Distance {
    private int pk_id;
    private String primary_address;
    private String target_address;
    private int value;
    private Integer is_delete;
    private Date create_time;
    private Date update_time;
}
