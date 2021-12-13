package com.example.campus.navigation.controller;

import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.service.PathService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class PathController {
    @Resource
    PathService pathService;

    @PostMapping("/path")
    public RestResult getPath(@RequestBody DistanceDto distanceDto) {
        return pathService.queryPlace(distanceDto);
    }
}
