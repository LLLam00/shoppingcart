<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加会员</title>

</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
	<h1>添加会员</h1>
	
	<s:form action="vip_save" enctype="multipart/form-data" method="post" namespace="/"
		theme="simple">
  <table border="0">
			<tr>
				<td>姓名</td>
				<td><s:textfield name="vname"></s:textfield></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:textfield name="gender"></s:textfield></td>
			</tr>
			<tr>
				<td>会员等级</td>
				<td><s:textfield name="level"></s:textfield></td>
			</tr>
			<tr>
				<td>会员积分</td>
				<td><s:textfield name="points"></s:textfield></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><s:textfield name="tele"></s:textfield></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="添加" onclick="return check(this.form)"></td>
			</tr>
		</table>  
</s:form>
<s:fielderror/>
<a href='vip_getAll?flag=0'>进入会员管理</a>  <a href="admin.jsp">返回首页</a></center>
</body>
</html>