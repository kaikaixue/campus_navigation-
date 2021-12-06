package com.example.campus.navigation.service.impl;

import com.example.campus.navigation.domain.DO.PlaceDetailDO;
import com.example.campus.navigation.domain.dto.PlaceDetailDTO;
import com.example.campus.navigation.domain.vo.PlaceDetailVO;
import com.example.campus.navigation.mapper.PlaceMapper;
import com.example.campus.navigation.service.PlaceService;
import com.example.campus.navigation.domain.DO.ListDO;
import com.example.campus.navigation.domain.vo.PlaceListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Resource
    PlaceMapper placeMapper;

    @Override
    public PlaceListVO getPlace() {
        List<ListDO> placeList = placeMapper.findAll();

        PlaceListVO playListVO = new PlaceListVO();
        playListVO.setList(placeList);
        playListVO.setTotal(placeList.size());

        return playListVO;
    }

    @Override
    public PlaceDetailVO getDetail(PlaceDetailDTO detailDTO) {

        PlaceDetailDO placeDetailDO = placeMapper.showDetail(detailDTO);

        PlaceDetailVO placeDetailVO = new PlaceDetailVO();

        placeDetailVO.setPictureList(placeDetailDO.getPicture().split(","));
        placeDetailVO.setName(placeDetailDO.getName());
        placeDetailVO.setDetail(placeDetailDO.getDetail());

        return placeDetailVO;

    }

    @Override
    public Integer getTotal() {
        return placeMapper.getTotal();
    }

}
