package com.hz.servlet;

import com.hz.pojo.HouseInfo;
import com.hz.service.HouseService;
import com.hz.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HouseService houseService = new HouseServiceImpl();
            int typeid = 0;
            String typeStr = request.getParameter("typeId");
            if (typeStr!=null){
                typeid = Integer.parseInt(typeStr);
            }
            String curr = request.getParameter("currpage");
            //当前页
            Integer currpage = 1 ;
            if(curr!=null)
            {
                currpage = Integer.parseInt(curr);
            }
            int totalPage = houseService.getHouseInfoPageSize(10);
            List<HouseInfo> houseInfoList = houseService.getHouseInfoList(typeid,currpage,10);
            request.getSession().setAttribute("houseInfoList",houseInfoList);
            request.getSession().setAttribute("totalPage",totalPage);
            request.getSession().setAttribute("currpage",currpage);
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
