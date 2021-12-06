package com.example.campus.navigation.service.impl;

import com.example.campus.navigation.domain.DO.DistanceDO;
import com.example.campus.navigation.domain.DO.DistanceSearchDO;
import com.example.campus.navigation.domain.DO.distanceDeal;
import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.domain.vo.DistanceSearchVO;
import com.example.campus.navigation.mapper.DistanceMapper;
import com.example.campus.navigation.mapper.PlaceMapper;
import com.example.campus.navigation.service.DistanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Resource
    DistanceMapper distanceMapper;

    @Resource
    PlaceMapper placeMapper;

    @Override
    public DistanceSearchVO Search(DistanceDto distanceDto) {

     return null;

    }
}



