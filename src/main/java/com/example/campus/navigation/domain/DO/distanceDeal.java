package com.example.campus.navigation.domain.DO;

import lombok.Data;

import java.util.List;
@Data
public class  distanceDeal{
    private Integer primaryAddress;
    private Integer targetAddress;
    private Integer minLength;
    private List<Integer> addressList;

    public distanceDeal(Integer prm, Integer tar, Integer minLength, List<Integer> addressList) {
        this.primaryAddress = prm;
        this.targetAddress = tar;
        this.minLength = minLength;
        this.addressList = addressList;
    }

    public distanceDeal() {

    }

}