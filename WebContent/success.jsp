<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>注册成功页面</title></head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<p>注册成功！</p>
欢迎你，<s:property value="user.username" />
<p><a href="userLogin.jsp" >去登录</a></p>
</center>
</body>
</html>
