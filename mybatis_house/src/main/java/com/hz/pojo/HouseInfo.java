package com.hz.pojo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HouseInfo {
    private int houseId;
    private String houseDesc;
    private HouseType houseType;
    private int monthlyRent;
    private String publishDate;
}
