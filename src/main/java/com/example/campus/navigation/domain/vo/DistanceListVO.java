package com.example.campus.navigation.domain.vo;

import com.example.campus.navigation.domain.DO.DistanceDO;
import lombok.Data;

import java.util.List;
@Data
public class DistanceListVO {
    private Integer total;
    private List<DistanceDO> distanceDOList;
}
