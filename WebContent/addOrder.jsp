<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加订单</title>

</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
	<h1>添加订单</h1>
	
	<s:form action="order_save" enctype="multipart/form-data" method="post" namespace="/"
		theme="simple">
  <table border="0">
			<tr>
				<td>买家</td>
				<td><s:textfield name="buyer"></s:textfield></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><s:textfield name="tele"></s:textfield></td>
			</tr>
			<tr>
				<td>交易状态</td>
				<td><s:textfield name="estate"></s:textfield></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="添加" onclick="return check(this.form)"></td>
			</tr>
		</table>  
</s:form>
<s:fielderror/>
<a href='order_getAll?flag=0'>进入订单管理</a>  <a href="admin.jsp">返回首页</a></center>
</body>
</html>