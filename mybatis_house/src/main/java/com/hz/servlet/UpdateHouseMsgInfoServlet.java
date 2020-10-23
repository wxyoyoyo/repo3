package com.hz.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.HouseInfo;
import com.hz.service.HouseService;
import com.hz.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateHouseMsgInfoServlet")
public class UpdateHouseMsgInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HouseService houseService = new HouseServiceImpl();
        int houseId = 0;
        String houseIdStr = request.getParameter("houseId");
        if(houseIdStr!=null){
            houseId = Integer.parseInt(houseIdStr);
        }
        System.out.println("houseId========"+houseId);
        try {
            HouseInfo houseInfo = houseService.getHouseInfoByHouseId(houseId);
            request.getSession().setAttribute("houseInfo",houseInfo);
            request.getRequestDispatcher("updatehouse.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
