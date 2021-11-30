package com.example.campus.navigation.service.impl;

import com.example.campus.navigation.entity.Place;
import com.example.campus.navigation.mapper.PlaceMapper;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import com.example.campus.navigation.service.PlaceService;
import com.example.campus.navigation.vo.ListVO;
import com.example.campus.navigation.vo.PlayListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Resource
    PlaceMapper placeMapper;

    @Override
    public RestResult getPlace() {
        List<ListVO> placeList = placeMapper.findAll();

        PlayListVO playListVO = new PlayListVO();
        playListVO.setList(placeList);
        playListVO.setTotal(placeList.size());

        return new RestResultBuilder().success(playListVO);
    }
}
