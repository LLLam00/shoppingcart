<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成功</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<p>操作成功！</p>
买家：${order.buyer}<br/>
联系方式：${order.tele}<br/>
交易状态：${order.estate}<br/><br/>
<a href="admin.jsp">返回首页</a>&nbsp;&nbsp;<a href="order_getAll?flag=0">查看订单列表</a>
</center></body>
</html>