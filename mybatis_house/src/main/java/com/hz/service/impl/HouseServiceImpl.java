package com.hz.service.impl;

import com.hz.dao.HouseDao;
import com.hz.pojo.HouseInfo;
import com.hz.pojo.HouseType;
import com.hz.service.HouseService;
import com.hz.utils.MyBatisUtil;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = MyBatisUtil.createSqlSession().getMapper(HouseDao.class);
    @Override
    public List<HouseInfo> getHouseInfoList(int typeId,int currpage,int pagenum) throws Exception {
        int offset = (currpage-1)*pagenum;
        return houseDao.getHouseInfoList(typeId,offset,pagenum);
    }

    @Override
    public int getHouseInfoPageSize(int pagenum) throws Exception {
        //总记录数
        int totalnum = houseDao.getHouseInfoPageSize();
        //总页数
        //总页数= 总条数%显示条数==0? (总条数/显示条数):(总条数/显示条数)+1
        int totalPage = totalnum%pagenum==0?(totalnum/pagenum):(totalnum/pagenum)+1;
        return totalPage;
    }

    @Override
    public int addHouseInfoList(String housedesc, int typeid, int monthlyrent) throws Exception {
        return houseDao.addHouseInfoList(housedesc,typeid,monthlyrent);
    }

    @Override
    public HouseInfo getHouseInfoByHouseId(int houseId) throws Exception {
        return  houseDao.getHouseInfoByHouseId(houseId);
    }
    @Override
    public int updateHouseInfoMsg(HouseInfo houseInfo) throws Exception {
        return houseDao.updateHouseInfoMsg(houseInfo);
    }

}
