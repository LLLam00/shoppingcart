<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>会员信息修改</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<br>
<h3>修改会员信息</h3>
<br>

<br>
<form action="vip_update" method="post" enctype="multipart/form-data">
<input type='hidden' name='vid' value='${vip.vid}'/>
<table>

<tr><td>姓名：<input type="text" value="${vip.vname}" name="vname"/></td></tr>
<tr><td>性别：<input type="text" value="${vip.gender}" name="gender"/></td></tr>
<tr><td>会员等级：<input type="text" value="${vip.level}" name="level"/></td></tr>
<tr><td>会员积分：<input type="text" value="${vip.points}" name="points"/></td></tr>
<tr><td>联系方式：<input type="text" value="${vip.tele}" name="tele"/></td></tr>
<tr><td><input type="submit" value="确认修改" onclick="return check(this.form)"></td></tr>
</table>
</form>
<a href="admin.jsp">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="manageVip.jsp">返回列表</a>
</center></body>
</html>