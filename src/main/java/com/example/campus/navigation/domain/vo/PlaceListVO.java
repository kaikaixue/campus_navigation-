package com.example.campus.navigation.domain.vo;

import com.example.campus.navigation.domain.DO.ListDO;
import com.example.campus.navigation.domain.DO.PlaceListDO;
import lombok.Data;

import java.util.List;
@Data
public class PlaceListVO {
        private Integer total;
        private List<PlaceListDO> List;
}
