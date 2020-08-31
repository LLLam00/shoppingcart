<%@ page contentType="text/html;charset=UTF-8" errorPage="/WEB-INF/error.jsp"%>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html>
<head>
<title>商品列表</title>

</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
<form action="product_search?flag=1" method="post">
<input type="text" name="pname" />
<input type="submit" value="搜索商品"/>
</form>
  <table border='1'>
     <tr>
       <td>图片</td><td>商品名</td><td>价格</td><td>详细信息</td>
     </tr>
    <demo:showProduct productList="${productList}">
     <tr>
       <td><img src="${product.picture}" width='100'/></td>
       <td>${product.pname}</td>
       <td>${product.price}</td>
       <td><a href="product_detail?id=${product.id}">详细信息</a></td>
     </tr>
    </demo:showProduct>
  </table>
  <br>
  <a href="index.jsp">返回首页</a>&nbsp;&nbsp;&nbsp;<a href="showCart.jsp">查看购物车</a>
</center>
</body></html>
