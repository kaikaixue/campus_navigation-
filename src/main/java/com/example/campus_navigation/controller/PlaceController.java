package com.example.campus_navigation.controller;

import com.example.campus_navigation.entity.Place;
import com.example.campus_navigation.mapper.PlaceMapper;
import com.example.campus_navigation.result.RestResult;
import com.example.campus_navigation.result.RestResultBuilder;
import com.example.campus_navigation.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("/homepage")
public class PlaceController {
    @Resource
    PlaceService placeService;

    @GetMapping("/playlist")
    public RestResult getPlace() {
        return placeService.getPlace();
    }
}
