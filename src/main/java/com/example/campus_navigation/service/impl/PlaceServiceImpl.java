package com.example.campus_navigation.service.impl;

import com.example.campus_navigation.entity.Place;
import com.example.campus_navigation.mapper.PlaceMapper;
import com.example.campus_navigation.result.RestResult;
import com.example.campus_navigation.result.RestResultBuilder;
import com.example.campus_navigation.service.PlaceService;
import com.example.campus_navigation.vo.ListVO;
import com.example.campus_navigation.vo.PlayListVO;
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
        List<Place> placeList = placeMapper.findAll();
        List<PlayListVO> playListVOList = new ArrayList<>();
        List<ListVO> listVOList = new ArrayList<>();
        for (int i = 0; i < placeList.size(); i++) {
            ListVO listVO = new ListVO();

            listVO.setName(placeList.get(i).getName());
            listVO.setPicture(placeList.get(i).getPicture());

            listVOList.add(listVO);
        }

        PlayListVO playListVO = new PlayListVO();
        playListVO.setTotal(placeList.size());
        playListVO.setList(listVOList);

        return new RestResultBuilder().success(playListVO);
    }
}
