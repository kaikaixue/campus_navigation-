package com.example.campus.navigation.mapper;

import com.example.campus.navigation.domain.DO.DistanceDO;
import com.example.campus.navigation.domain.DO.DistanceNameDo;
import com.example.campus.navigation.domain.DO.PlaceIdName;

import java.util.List;

public interface PathMapper {
    List<PlaceIdName> queryPlace();

    List<DistanceNameDo> queryDistance();
}
