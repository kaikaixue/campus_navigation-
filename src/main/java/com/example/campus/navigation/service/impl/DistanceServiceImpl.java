package com.example.campus.navigation.service.impl;


import com.example.campus.navigation.domain.DO.DistanceDO;
import com.example.campus.navigation.domain.DO.DistanceSearchDO;
import com.example.campus.navigation.domain.DO.PlaceIdName;
import com.example.campus.navigation.domain.dto.DistanceDto;
import com.example.campus.navigation.domain.vo.DistanceSearchVO;
import com.example.campus.navigation.mapper.DistanceMapper;
import com.example.campus.navigation.mapper.PlaceMapper;
import com.example.campus.navigation.service.DistanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Resource
    DistanceMapper distanceMapper;

    @Resource
    PlaceMapper placeMapper;

    @Override
    public DistanceSearchVO Search(DistanceDto distanceDto) {

        List<PlaceIdName> placeIdNameList = placeMapper.getIdName();


        List<DistanceDO> distanceDOList = distanceMapper.getPTValue();


        MatGraphClass ma = new MatGraphClass();


        for(int i=0;i<distanceDOList.size();i++) {
            ma.insertEdges(distanceDOList.get(i).getPrimaryAddress(),
                    distanceDOList.get(i).getTargetAddress(),
                    distanceDOList.get(i).getValue());
        }


        ma.DFS(ma,distanceDto.getPrimaryAddress(), distanceDto.getTargetAddress());

        List<List> stackList = ma.lists;

        DistanceSearchVO distanceSearchVO = new DistanceSearchVO();

        distanceSearchVO.setTotal(stackList.size());


        List<DistanceSearchDO> distanceSearchDOList = new ArrayList<>();
        //
        for(int i=0;i<stackList.size();i++) {
            List<String> place = new ArrayList<>();
            Integer sum = 0;
            DistanceSearchDO distanceSearchDO = new DistanceSearchDO();
            for(int j=0;j<stackList.get(i).size();j++) {
                int flag = 1;
                if(j == stackList.get(i).size()-1) {
                    flag = 0;
                }

               int  id1= (int) stackList.get(i).get(j);
               int  id2 = (int) stackList.get(i).get(j+flag);

                for(int m =0;m<placeIdNameList.size();m++) {
                    if(id1 == placeIdNameList.get(m).getId()) {
                        place.add(placeIdNameList.get(m).getName());
                        break;
                    }
                }

                for(int n = 0;n<distanceDOList.size();n++) {

                    if((id1 == distanceDOList.get(n).getPrimaryAddress()
                    &&id2 ==  distanceDOList.get(n).getTargetAddress())
                    ||(id1 == distanceDOList.get(n).getTargetAddress()
                            &&id2 ==  distanceDOList.get(n).getPrimaryAddress())
                    ) {

                       sum+=distanceDOList.get(n).getValue();

                    break;

                    }
                }
            }
            distanceSearchDO.setDistance(String.valueOf(sum));
            distanceSearchDO.setTime(String.valueOf(sum));
            distanceSearchDO.setPlace(place.toArray(new String[place.size()]));
            distanceSearchDOList.add(distanceSearchDO);
        }

        distanceSearchVO.setDistanceSearchDOList(distanceSearchDOList);

        return distanceSearchVO;

    }


}


class MatGraphClass {
    final int MAXV = 30;
    final int INF = 0x3f3f3f3f;
    int[][] edges;
    int n, e;
    String[] vexs;
    public MatGraphClass() {
        edges = new int[MAXV][MAXV];
        for(int i=0;i< edges.length;i++) {
            for(int j=0;j<edges.length;j++) {
                edges[i][j]=INF;
            }
        }
        vexs = new String[MAXV];
        this.n=MAXV;
        this.e=0;
    }
    public void insertEdges(int v1,int v2,int value) {
        edges[v1][v2] = value;
        edges[v2][v1] = value;
        this.e++;
    }

    public void CreateMatGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;
        for (int i = 0; i < n; i++) {
            edges[i] = new int[n];
            System.arraycopy(a[i], 0, edges[i], 0, n);
        }
    }

    public void DispMatGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == INF) {
                    System.out.printf("%4s", "∞");
                } else {
                    System.out.printf("%4d", edges[i][j]);
                }
            }
            System.out.println();
        }
    }
    //创建一个堆栈

    Stack<Integer> stack = new Stack<>();
       List<Integer> list = new ArrayList<>();
     int[] visited = new int[100];
     List<List> lists = new ArrayList<>();

    public  void DFS(MatGraphClass g,int start,int end) {
        visited[start] = 1; //1代表已经访问过，真值
        stack.push(start);
        if(start == end) {
            List<Integer> o =  new ArrayList<Integer>(stack);
           lists.add(o);
        }
        for(int i=1;i<g.n;i++) {
            if(visited[i]==0&&g.edges[start][i]< g.INF) {
                DFS(g,i,end);
            }
        }
        stack.pop();
        visited[start] = 0;
    }



}

