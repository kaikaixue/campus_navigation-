package com.example.campus_navigation.mapper;

import com.example.campus_navigation.entity.Place;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface PlaceMapper {
    @Select("select * from t_place")
    List<Place> findAll();
}
