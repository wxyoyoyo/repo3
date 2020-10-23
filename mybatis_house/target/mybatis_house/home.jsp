<%--
  Created by IntelliJ IDEA.
  User: WXyoyoyo
  Date: 2020/9/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home</title>
</head>

<body>
    <a href="addhouse.jsp"><h3>发布房源</h3></a>
    <table>
        <tr>
            <td>序号</td>
            <td>房屋描述</td>
            <td>房屋类型</td>
            <td>租金</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${houseInfoList}" var="houseInfo" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${houseInfo.houseDesc}</td>
                <td><a href="HouseServlet?typeId=${houseInfo.houseType.typeId}">${houseInfo.houseType.typeName}</a></td>
                <td>${houseInfo.monthlyRent}</td>
                <td>${houseInfo.publishDate}</td>
                <td><a href="UpdateHouseMsgInfoServlet?houseId=${houseInfo.houseId}">修改</a>/<a href="">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <a
                    <c:if test="${currpage>1}"> href="HouseServlet?currpage=${currpage-1}"</c:if>>
                    <input type="button" value="上一页">
                </a>
            </td>
            <td>当前${currpage}页/共${totalPage}页</td>
            <td>
                <a
                    <c:if test="${currpage<totalPage}"> href="HouseServlet?currpage=${currpage+1}"</c:if>>
                    <input type="button" value="下一页">
                </a>
            </td>
        </tr>
    </table>
</body>
</html>
