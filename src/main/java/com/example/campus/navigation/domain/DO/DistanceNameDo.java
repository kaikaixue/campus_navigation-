package com.example.campus.navigation.domain.DO;

import lombok.Data;

@Data
public class DistanceNameDo {
    private String primaryName;
    private String targetName;
    private double value;
}
