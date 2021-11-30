package com.example.campus.navigation.mapper;


import com.example.campus.navigation.domain.DO.DistanceDO;
import com.example.campus.navigation.domain.dto.DistanceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistanceMapper {

List<DistanceDO> Search(DistanceDto distanceDto);



}
