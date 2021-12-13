package com.example.campus.navigation.service.impl;

import com.example.campus.navigation.domain.DO.DistanceNameDo;
import com.example.campus.navigation.domain.DO.PlaceIdName;
import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.domain.vo.QueryPlaceVO;
import com.example.campus.navigation.mapper.PathMapper;
import com.example.campus.navigation.result.RestResult;
import com.example.campus.navigation.result.RestResultBuilder;
import com.example.campus.navigation.service.PathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PathServiceImpl implements PathService {
    private static Random random = new Random();

    @Resource
    PathMapper pathMapper;

    Graph<String> graph = new Graph<>(false);

    @Override
    public RestResult queryPlace(DistanceDto distanceDto) {
        List<PlaceIdName> placeList = pathMapper.queryPlace();

        String start = null;
        String end = null;

        for (PlaceIdName placeIdName : placeList) {
            if (placeIdName.getId() == distanceDto.getPrimaryAddress()) {
                start = placeIdName.getName();
            } else if (placeIdName.getId() == distanceDto.getTargetAddress()) {
                end = placeIdName.getName();
            }
            graph.addVertex(placeIdName.getName(), placeIdName.getId());
        }
        List<DistanceNameDo> distanceDoList = pathMapper.queryDistance();
        for (DistanceNameDo distanceNameDo : distanceDoList) {
            graph.addEdge(distanceNameDo.getPrimaryName(), distanceNameDo.getTargetName(), distanceNameDo.getValue());
        }

        Map o = (Map) graph.getSmallestDistance(start, end);

        QueryPlaceVO queryPlaceVO = new QueryPlaceVO();

        queryPlaceVO.setPath((List) o.get("pathList"));
        queryPlaceVO.setDistance((Double) o.get("minDistance"));
        queryPlaceVO.setTime(random.nextInt(10) + 10);

        return new RestResultBuilder().success(queryPlaceVO);
    }
}
