package com.hz.dao;

import com.hz.pojo.HouseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseDao {
    List<HouseInfo> getHouseInfoList(@Param("typeId")Integer typeId,@Param("offset")int offset,@Param("pagenum")int pagenum )throws Exception;
    int getHouseInfoPageSize() throws Exception;
    int addHouseInfoList(@Param("housedesc") String housedesc, @Param("typeid") int typeid, @Param("monthlyrent") int monthlyrent) throws Exception;
    int updateHouseInfoMsg(@Param("houseInfo") HouseInfo houseInfo)throws Exception;
    HouseInfo getHouseInfoByHouseId(@Param("houseId") int houseId) throws Exception;
}
