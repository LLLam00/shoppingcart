<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>订单修改</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<br>
<h3>修改订单</h3>
<br>

<br>
<form action="order_update" method="post" enctype="multipart/form-data">
<input type='hidden' name='oid' value='${order.oid}'/>
<table>

<tr><td>买家：<input type="text" value="${order.buyer}" name="buyer"/></td></tr>
<tr><td>联系方式：<input type="text" value="${order.tele}" name="tele"/></td></tr>
<tr><td>状态：<input type="text" value="${order.estate}" name="estate"/></td></tr>
<tr><td><input type="submit" value="确认修改" onclick="return check(this.form)"></td></tr>
</table>
</form>
<a href="admin.jsp">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="manageOrder.jsp">返回列表</a>
</center></body>
</html>