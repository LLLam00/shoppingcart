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
<title>商品管理</title>
<script type="text/javascript">
function del(){
	if(confirm("确定要删除吗?")){
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
<br><br>
<form action="product_search?flag=0" method="post">
<input type="text" name="pname" />
<input type="submit" value="查找商品"/>
</form>

<br>
<a href="addProduct.jsp">点击添加商品</a>
<br><br>
<table border='1'>
     <tr>
       <td>图片</td><td>名称</td><td>价格</td><td>库存</td><td colspan='2'>操作</td>
     </tr>
    <demo:showProduct productList="${productList}">
     <tr>
     	<td><img src="${product.picture}" width='100'></td>
       <td>${product.pname}</td>
       <td>${product.price}</td>
       <td>${product.stock}</td>
       <td><a href="product_delete?id=${product.id}" onClick="return del()">删除</a></td>
       <td><a href="product_alter?id=${product.id}">修改</a></td>
     </tr>
    </demo:showProduct>
  </table>
  <br/>
  <a href="admin.jsp">返回首页</a>
</body>
</html>