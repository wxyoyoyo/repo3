<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WXyoyoyo
  Date: 2020/9/11
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改信息</title>
</head>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<body>
    <table>
        <tr>
            <td>房屋编号:</td>
            <td><input type="text" value="${houseInfo.houseId}" id="houseid" disabled></td>
        </tr>
        <tr>
            <td>房屋描述:</td>
            <td><input type="text" value="${houseInfo.houseDesc}" id="housedesc"></td>
        </tr>
        <tr>
            <td>户型编号:</td>
            <td><input type="text" value="${houseInfo.houseType.typeId}" id="typeid"></td>
        </tr>
        <tr>
            <td>租金:</td>
            <td><input type="text" value="${houseInfo.monthlyRent}" id="monthlyrent"></td>
        </tr>
        <tr>
            <td>发布日期:</td>
            <td><input type="text" value="${houseInfo.publishDate}" id="publishdate"></td>
        </tr>
        <tr>
            <td><input type="button" value="提交" id="tj"></td>
            <td><input type="button" value="取消" id="qx"></td>
        </tr>
    </table>
</body>
<script type="text/javascript">
    $(function () {
        $.getJSON("AddHouseInfoServlet",null,function (res) {
            $.each(res,function (k,v) {
                console.log("k======"+k);
                console.log("v===="+v);
                $("#type1").append("<option value="+v.typeId+">"+v.typeName+"</option>");
            })
        })
        $("#tj").click(function () {
            var houseId = $("#houseid").val();
            var houseDesc = $("#housedesc").val();
            var typeId = $("#typeid").val();
            var monthlyRent = $("#monthlyrent").val();
            var publishDate = $("#publishdate").val();
            $.ajax({
                url:"UpdateHouseInfoServlet",
                type:"post",
                data:{"houseId":houseId,"houseDesc":houseDesc,"typeId":typeId,"monthlyRent":monthlyRent,"publishDate":publishDate},
                dataType:"json",
                success:function (res) {
                    if(res.code == 1){
                        alert(res.msg);
                        location.href="HouseServlet";
                    }else{
                        alert(res.msg);
                    }
                },
                error:function () {
                    alert("请求失败");
                }
            })
        })
        $("#qx").click(function () {
            location.href="home.jsp";
        })
    })
</script>
</html>
