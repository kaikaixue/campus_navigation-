package com.example.campus.navigation.service;

import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.result.RestResult;

public interface PathService {
    RestResult queryPlace(DistanceDto distanceDto);
}
