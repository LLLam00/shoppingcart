<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function check(form) {
	if(form.pname.value=='') {
		alert("商品名不能为空!");
		form.pname.focus();
		return false;
	}
	if(form.price.value=='') {
		alert("价格不能为空!");
		form.price.focus();
		return false;
	}
	var regu2=/^\d+(.\d{1,2})?$/
			if(!regu2.test(form.price.value)){
				alert("价格格式无效！");
				form.price.focus();
				return false;
			}
	var regu = /^[1-9]\d*$/;
	if(!regu.test(form.stock.value)) {
		alert("库存必须为正整数!");
		form.stock.focus();
		return false;
	}
  }
 </script>
<title>修改</title>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
原图：<br/><img src="${product.picture}" width='250'>
<form action="product_update" method="post" enctype="multipart/form-data">
<input type='hidden' name='id' value='${product.id}'/>
<input type='hidden' name='picture' value='${product.picture}'/>
<table>

<tr><td>名称：<input type="text" value="${product.pname}" name="pname"/></td></tr>
<tr><td>价格：<input type="text" value="${product.price}" name="price"/></td></tr>
<tr><td>库存：<input type="text" value="${product.stock}" name="stock"/></td></tr>
<tr><td><input type="submit" value="确认修改" onclick="return check(this.form)"></td></tr>
</table>
</form>
<a href="admin.jsp">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="manageProduct.jsp">返回列表</a>
</center></body>
</html>