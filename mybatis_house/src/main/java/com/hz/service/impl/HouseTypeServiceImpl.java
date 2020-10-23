package com.hz.service.impl;

import com.hz.dao.HouseTypeDao;
import com.hz.pojo.HouseInfo;
import com.hz.pojo.HouseType;
import com.hz.service.HouseService;
import com.hz.service.HouseTypeService;
import com.hz.utils.MyBatisUtil;

import java.util.List;

public class HouseTypeServiceImpl implements HouseTypeService {
    private HouseTypeDao houseTypeDao = MyBatisUtil.createSqlSession().getMapper(HouseTypeDao.class);
    @Override
    public List<HouseType> getHouseTypeList() throws Exception {
        return houseTypeDao.getHouseTypeList();
    }

    @Override
    public HouseType getHouseTypeByTypeId(int typeId) throws Exception {
        return houseTypeDao.getHouseTypeByTypeId(typeId);
    }
}
