<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/WEB-INF/error.jsp"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
text-align:center
}
table{margin:auto}
</style>
<meta charset="UTF-8">
<title>订单管理</title>
<script type="text/javascript">
function del(){
	if(confirm("确定要取消订单吗?")){
	return true;
	}else{
	return false;
	}
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
	if(name=="undefined"){
		alert("请登录后再操作！")
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
<br><br>
<form action="order_search?flag=0" method="post">
<input type="text" name="buyer" />
<input type="submit" value="查找订单"/>
</form>

<br>
<a href="addOrder.jsp">点击添加订单</a>
<br><br>
<table border='1'>
     <tr>
       <td>订单号</td><td>买家</td><td>下单时间</td><td>状态</td><td colspan='2'>操作</td>
     </tr>
    <demo:showOrder orderList="${orderList}">
     <tr>
     	<td>${order.oid}</td>
       <td>${order.buyer}</td>
       <td>${order.tele}</td>
       <td>${order.estate}</td>
       <td><a href="order_delete?oid=${order.oid}" onClick="return del()">取消</a></td>
       <td><a href="order_alter?oid=${order.oid}">修改</a></td>
     </tr>
    </demo:showOrder>
  </table>
  <br/>
  <a href="admin.jsp">返回首页</a>
</body>
</html>