<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.domain.*"%>
<html>
<head>
<title>用户购物车信息</title>
<link href="myStyle.css" rel="stylesheet" type="text/css" />
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
	<% 
 	 // 从购物车中取出每件商品并存储在ArrayList中
 	ShoppingCart cart=(ShoppingCart)session.getAttribute("cart");
	if(cart==null){
	%>
	暂无购物信息
	<%
	}else{
  	ArrayList<GoodsItem> items = new ArrayList<GoodsItem>(cart.getItems());
	%>
	<h4>我的购物车</h4>
	<table>
		<tr>
			<td colspan='4' style='width: 80px'></td>
			<td style='width: 80px'>商品名称</td>
			<td style='width: 80px'>价格</td>
			<td style='width: 50px'>数量</td>
			<td style='width: 80px'>小计</td>
			<td style='width: 80px'>是否删除</td>
		</tr>
<%
  // 显示购物车中每件商品信息
  for (GoodsItem goodsItem : items) {
    Product product = goodsItem.getProduct();
%>
		<tr>
			<td colspan='4' style='width: 80px'><img src='<%=product.getPicture()%>' width='50' /></td>
			<td><a href="product_detail?id=<%=product.getId()%>"><%=product.getPname() %></a></td>
			<td><%=product.getPrice() %></td>
			<td><%=goodsItem.getQuantity()%></td>
			<td><%=((int)(product.getPrice() * goodsItem.getQuantity()*100+0.5))/100.00 %></td>
			<td><a href="product_deleteItem?id=<%=product.getId() %>">删除</a></td>
		</tr>
<%
    }
%>    
		
	</table>
<%
}
%>

<p align="right">总计:<%=cart.getTotal() %></p>
	<a href="product_getAll?flag=1">继续购物</a>&nbsp;&nbsp;<a href="index.jsp">返回首页</a>
</center>
</body>
</html>
