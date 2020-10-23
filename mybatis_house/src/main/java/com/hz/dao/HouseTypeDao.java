package com.hz.dao;

import com.hz.pojo.HouseType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseTypeDao {
    List<HouseType> getHouseTypeList()throws Exception;
    HouseType getHouseTypeByTypeId(@Param("typeId") int typeId) throws Exception;
}
