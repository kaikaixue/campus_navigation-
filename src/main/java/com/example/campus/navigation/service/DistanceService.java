package com.example.campus.navigation.service;

import com.example.campus.navigation.domain.DO.DistanceDO;
import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.domain.vo.DistanceSearchVO;


public interface DistanceService {
    /**
     * 查找最短路径
     * @return
     */
    DistanceSearchVO Search(DistanceDto distanceDto);
}
