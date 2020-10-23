package com.hz.servlet;


import com.alibaba.fastjson.JSONObject;
import com.hz.service.HouseService;
import com.hz.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddHouseServlet")
public class AddHouseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String housedesc = new String(request.getParameter("housedesc").getBytes("iso-8859-1"),"utf-8");;
        int monthlyrent = Integer.parseInt(request.getParameter("monthlyrent"));
        int typeid = Integer.parseInt(request.getParameter("typeid"));
        HouseService houseService = new HouseServiceImpl();
        try {
            int i = houseService.addHouseInfoList(housedesc,typeid,monthlyrent);
            PrintWriter out = response.getWriter();
            if(i>0){
                out.print("{\"code\":1,\"msg\":\"新增成功\"}");

            }else{
                out.print("{\"code\":0,\"msg\":\"新增失败\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
