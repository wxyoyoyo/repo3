package com.hz.service;

import com.hz.pojo.HouseInfo;
import com.hz.pojo.HouseType;

import java.util.List;

public interface HouseService {
    List<HouseInfo> getHouseInfoList(int typeId,int offset,int pagenum)throws Exception;
    int getHouseInfoPageSize(int pagenum) throws Exception;
    int addHouseInfoList(String housedesc,int typeid,int monthlyrent) throws Exception;
    HouseInfo getHouseInfoByHouseId(int houseId) throws Exception;
    int updateHouseInfoMsg(HouseInfo houseInfo)throws Exception;

}
