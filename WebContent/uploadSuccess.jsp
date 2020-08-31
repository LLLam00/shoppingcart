<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成功</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<p>操作成功！</p>
图片：<br/><img src="${product.picture}" width='200'><br/>
商品名称：${product.pname}<br/>
商品价格：${product.price}<br/>
商品库存：${product.stock}<br/><br/>
<a href="addProduct.jsp">继续上传</a>
<a href="admin.jsp">返回首页</a>&nbsp;&nbsp;<a href="product_getAll?flag=0">查看商品列表</a>
</center></body>
</html>