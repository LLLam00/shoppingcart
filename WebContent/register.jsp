<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest(){
	if (window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}
}
function validate(){
	createXMLHttpRequest();
	var myname=document.getElementById("myname");
	var url="user_get?myname="+escape(myname.value);
	xmlHttp.open("GET",url,true);
	xmlHttp.onreadystatechange=handleStateChange;
	xmlHttp.send(null);
}
function handleStateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
			var messageArea=document.getElementById("result");
			messageArea.innerHTML="<span><font color='red'>"+message+"</font></span>";
		}
	}
}

function check(form) {
	if(form.username.value=='') {
		alert("用户名不能为空!");
		return false;
	}
	if(form.password.value=='') {
		alert("密码不能为空!");
		return false;
	}
  }
</script>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>	<h3>注册新用户</h3>
	<s:form action="user_regist" namespace="/">
		<s:actionerror />
		<s:textfield name="username" label="用户名" id="myname"
			onblur="validate()" />
		<span id="result"> </span>
		<s:password name="password" label="密      码" />
		<s:submit value="注册" onclick="return check(this.form)"/>
	</s:form>
	<br>已有账号，去
	<a href="userLogin.jsp">登录</a></center>
</body>
</html>