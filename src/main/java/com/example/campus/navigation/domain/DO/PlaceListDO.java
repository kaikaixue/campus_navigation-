package com.example.campus.navigation.domain.DO;

import lombok.Data;

@Data
public class PlaceListDO {
    private Integer pkId;
    private String[] picture;
    private String name;
    private String detail;
    private String latitude;
    private String longitude;

}
