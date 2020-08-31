<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body{
text-align:center}
</style>
<title>管理员界面</title>
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
		// 调用
		toast('您已自动登录');
	}else{
		alert("请先登录")
		top.location.href="userLogin.jsp";
	}
}
function checkLogin(){
	if(<%=session.getAttribute("HiAdmin")%>
	== null) {
			var adminName = decodeURIComponent(getCookieByArray('adminName'));
			checkCookie(adminName);
		}
	}
	checkLogin();
</script>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<p>欢迎，${user.username }来到云商城管理系统
<a href="user_adminout">退出登录</a>
</p>
<a href="product_getAll?flag=0">商品管理</a>
<a href="addProduct.jsp">点击添加商品</a>
<br/><br/>
<a href="order_getAll?flag=0">订单管理</a>
<a href="addOrder.jsp">点击添加订单</a>
<br/><br/>
<a href="vip_getAll?flag=0">会员管理</a>
<a href="addVip.jsp">点击添加会员</a>
</body>
</html>