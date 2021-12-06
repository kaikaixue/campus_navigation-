package com.example.campus.navigation.domain.vo;

import com.example.campus.navigation.domain.DO.DistanceSearchDO;
import lombok.Data;
import java.util.List;

@Data
public class DistanceSearchVO {

    private Integer total;
    private List<DistanceSearchDO> distanceSearchDOList;
}
