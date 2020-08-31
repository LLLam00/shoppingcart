<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
text-align:center}
</style>
<meta charset="UTF-8">
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<title>首页</title>
<script type="text/javascript">
function toast(msg){
    setTimeout(function(){
        document.getElementsByClassName('toast-wrap')[0].getElementsByClassName('toast-msg')[0].innerHTML=msg;
        var toastTag = document.getElementsByClassName('toast-wrap')[0];
        toastTag.className = toastTag.className.replace('toastAnimate','');
        setTimeout(function(){
            toastTag.className = toastTag.className + ' toastAnimate';
        }, 100);
    },500);
  }
function getCookieByArray(name){
	 var cookies = document.cookie.split(';');
	 var c;
	 for(var i=0; i<cookies.length ; i++){
	  c = cookies[i].split('=');
	  if (c[0].replace(' ', '') == name) {
	   return c[1];
	  }
	 }
	}
function checkCookie(name){
	if(name!="undefined"){
		//session.setAttribute("loggedIn",true);
		// 调用
		toast('您已自动登录');
	}else{
		alert("请先登录")
		top.location.href="userLogin.jsp";
	}
}
function checkLogin(){
	if(<%=session.getAttribute("loggedIn")%>==null) {
			var username = decodeURIComponent(getCookieByArray('username'));
			checkCookie(username);
		}
	}
	checkLogin();
</script>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
	<p align="right">
	欢迎${user.username }来到云商城！！
	<a href="user_logout">退出登录</a><br/><br/>
	</p>
	<a href="product_getAll?flag=1">浏览商品</a><br/><br/>
	<a href="showCart.jsp">查看购物车</a><br/><br/>
	
	<div class="toast-wrap">
		<span class="toast-msg" style="color:white"></span>
	</div>
</body>
</html>