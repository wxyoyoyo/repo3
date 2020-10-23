package com.hz.service;

import com.hz.pojo.HouseType;

import java.util.List;

public interface HouseTypeService {
    List<HouseType> getHouseTypeList()throws Exception;
    HouseType getHouseTypeByTypeId(int typeId) throws Exception;
}
