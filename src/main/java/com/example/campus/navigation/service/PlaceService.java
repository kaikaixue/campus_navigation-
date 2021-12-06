package com.example.campus.navigation.service;

import com.example.campus.navigation.domain.DO.PlaceDetailDO;
import com.example.campus.navigation.domain.dto.PlaceDetailDTO;
import com.example.campus.navigation.domain.vo.PlaceDetailVO;
import com.example.campus.navigation.domain.vo.PlaceListVO;


public interface PlaceService {
    /**
     * 得到地址
     * @return
     */
    PlaceListVO getPlace();


    /**
     * 得到详情
     */
    PlaceDetailVO getDetail(PlaceDetailDTO detailDTO);

    Integer getTotal();
}
