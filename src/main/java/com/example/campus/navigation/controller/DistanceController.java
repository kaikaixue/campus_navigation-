package com.example.campus.navigation.controller;


import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import com.example.campus.navigation.service.DistanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class DistanceController {
    @Resource
    DistanceService distanceService;
    @PostMapping("/distance")
    public RestResult getDistance(@RequestBody DistanceDto distanceDto) {


            return new RestResultBuilder<>().success(distanceService.Search(distanceDto));
    }

}
