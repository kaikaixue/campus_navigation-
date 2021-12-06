package com.example.campus.navigation.controller;

import com.example.campus.navigation.domain.dto.PlaceDetailDTO;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import com.example.campus.navigation.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/homepage")
public class PlaceController {
    @Resource
    PlaceService placeService;

    @PostMapping("/placeList")
    public RestResult getPlace() {
        return  new RestResultBuilder<>().success(placeService.getPlace());
    }

    @PostMapping("/detail")
    public RestResult showDetail(@RequestBody PlaceDetailDTO detailDTO) {

        return new RestResultBuilder<>().success(placeService.getDetail(detailDTO));
    }

    @PostMapping("/getTotal")
    public Integer getTotal () {
        return placeService.getTotal();
    }
}
