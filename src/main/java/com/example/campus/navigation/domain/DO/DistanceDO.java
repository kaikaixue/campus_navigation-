package com.example.campus.navigation.domain.DO;

import lombok.Data;

@Data
public class DistanceDO {
    private Integer primaryAddress;
    private Integer targetAddress;
    private Integer value;
}
