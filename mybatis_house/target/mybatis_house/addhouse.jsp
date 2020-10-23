<%--
  Created by IntelliJ IDEA.
  User: WXyoyoyo
  Date: 2020/9/10
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布房源</title>
</head>

<body>
    <h2>发布房源</h2>
    <table>
        <tr>
            <td></td>
            <td><a href="HouseServlet">返回首页</a></td>
        </tr>
        <tr>
            <td>房屋描述：</td>
            <td><input type="text" name="housedesc" id="housedesc"></td>
        </tr>
        <tr>
            <td>户型：</td>
            <td>
                <select name="type" id="type1">
                </select>
            </td>
        </tr>
        <tr>
            <td>租金：</td>
            <td><input type="text" id="monthlyrent">元/月</td>
        </tr>
        <tr>
            <td><input type="button" value="提交" id="tj"></td>
            <td><input type="button" value="重置" id="cz"></td>
        </tr>
    </table>
</body>
</html>
<script type="text/javascript" src="jquery-1.11.1.min.js" charset="utf-8"></script>
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
                var housedesc = $("#housedesc").val();
                var typeid = $("#type1").val();
                var monthlyrent = $("#monthlyrent").val();
                var datajson = {
                    "housedesc":housedesc,
                    "typeid":typeid,
                    "monthlyrent":monthlyrent
                }
                $.ajax({
                    url:"AddHouseServlet",
                    data:datajson,
                    dataType:"json",
                    success:function (res) {
                        if(res.code >0){
                            alert(res.msg);
                            location.href = "HouseServlet";
                        }else{
                            alert(res.msg);
                        }
                    }
                })
            })
    })

</script>
