package com.example.campus.navigation.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class QueryPlaceVO {
    private Double distance;
    private Integer time;
    private List path;
}
