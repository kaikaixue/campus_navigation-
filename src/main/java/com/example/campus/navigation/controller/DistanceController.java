package com.example.campus.navigation.controller;


import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.mapper.DistanceMapper;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class DistanceController {
    @Resource
    DistanceMapper distanceMapper;

    @PostMapping("/distance")
    public RestResult getDistance(DistanceDto distanceDto) {


            return new RestResultBuilder<>().success(distanceMapper.Search(distanceDto));
    }

}
