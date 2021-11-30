package com.example.campus.navigation.controller;

import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/homepage")
public class PlaceController {
    @Resource
    PlaceService placeService;

    @GetMapping("/placeList")
    public RestResult getPlace() {
        return placeService.getPlace();
    }
}
