package com.hz.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.HouseInfo;
import com.hz.pojo.HouseType;
import com.hz.service.HouseService;
import com.hz.service.HouseTypeService;
import com.hz.service.impl.HouseServiceImpl;
import com.hz.service.impl.HouseTypeServiceImpl;
import com.hz.utils.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateHouseInfoServlet")
public class UpdateHouseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int houseId = Integer.parseInt(request.getParameter("houseId"));
        String houseDesc = request.getParameter("houseDesc");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int monthlyRent = Integer.parseInt(request.getParameter("monthlyRent"));
        String publishDate = request.getParameter("publishDate");
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setHouseId(houseId);
        houseInfo.setHouseDesc(houseDesc);
        houseInfo.setMonthlyRent(monthlyRent);
        houseInfo.setPublishDate(publishDate);
        HouseTypeService houseTypeService = new HouseTypeServiceImpl();
        try {
            HouseType houseType = houseTypeService.getHouseTypeByTypeId(typeId);
            houseInfo.setHouseType(houseType);
            HouseService houseService = new HouseServiceImpl();
            int i = houseService.updateHouseInfoMsg(houseInfo);
            JSONObject json = new JSONObject();
            PrintWriter out = response.getWriter();
            Message message = null;
            if (i>0){
                message = new Message(1,"修改成功");
            }else{
                message = new Message(0,"修改失败");
            }
            String jsonstr = json.toJSONString(message);
            System.out.println("jsonstr==========="+jsonstr.toString());
            out.print(jsonstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
