<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>

</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<h3>用户登录</h3>
<s:form action="user_login" namespace="/">
	<s:actionerror />
  <s:textfield name="user.username" label="用户名"  />
  <s:password name="user.password" label="密 码"/>
  <s:hidden name="check" label="自动登录"/>
  <s:radio list="#{'1':'普通用户','0':'管理员'}" name="userType" value="1"/>
  <s:submit value="登录" />
</s:form>
<br/>
还没有账号？去<a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;
</center>
</body>
</html>
