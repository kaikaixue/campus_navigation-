package com.example.campus.navigation.mapper;

import com.example.campus.navigation.domain.DO.ListDO;
import com.example.campus.navigation.domain.DO.PlaceDetailDO;
import com.example.campus.navigation.domain.DO.PlaceIdName;
import com.example.campus.navigation.domain.dto.PlaceDetailDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface PlaceMapper {

   List<ListDO> findAll();

   PlaceDetailDO showDetail(PlaceDetailDTO detailDTO);

   Integer getTotal();

   String findName(Integer id);

   List<PlaceIdName> getIdName();
   
}
