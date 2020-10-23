package com.hz.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.HouseType;
import com.hz.service.HouseTypeService;
import com.hz.service.impl.HouseTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AddHouseInfoServlet")
public class AddHouseInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        HouseTypeService houseTypeService = new HouseTypeServiceImpl();

        try {
            List<HouseType> houseTypes = houseTypeService.getHouseTypeList();
            JSONObject json = new JSONObject();
            String jsonstr = json.toJSONString(houseTypes);
            PrintWriter out = response.getWriter();
            out.print(jsonstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
