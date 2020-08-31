<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
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
	if(form.pictureType.value=='') {
		alert("请上传图片");
		return false;
	}
	
  }
 </script>
</head>
<body background="background.jpg"  
style="background-repeat:no-repeat;
background-size:300% 500%;background-height:500px;
background-attackment:fixed">
<center>
	<h1>添加商品</h1>
	
	<s:form action="product_save" enctype="multipart/form-data" method="post" namespace="/"
		theme="simple">
  <table border="0">
			<tr>
				<td>商品名称</td>
				<td><s:textfield name="pname"></s:textfield></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><s:textfield name="price"></s:textfield></td>
			</tr>
			<tr>
				<td>商品库存</td>
				<td><s:textfield name="stock"></s:textfield></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><s:file name="upload"></s:file></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="添加" onclick="return check(this.form)"></td>
			</tr>
		</table>  
</s:form>
<s:fielderror/>
<a href='product_getAll?flag=0'>进入商品管理</a>  <a href="admin.jsp">返回首页</a></center>
</body>
</html>