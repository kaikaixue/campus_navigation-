package com.example.campus.navigation.domain.DO;

import lombok.Data;

import java.util.List;
@Data
public class DistanceDO {
    private Integer primaryAddress;
    private Integer targetAddress;
    private Integer value;
}
