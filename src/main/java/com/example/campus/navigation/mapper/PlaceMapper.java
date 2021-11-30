package com.example.campus.navigation.mapper;

import com.example.campus.navigation.entity.Place;
import com.example.campus.navigation.vo.ListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface PlaceMapper {
    List<ListVO> findAll();
}
