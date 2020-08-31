<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head><title>商品详细信息</title>
<!--使用JavaScript脚本保证文本域中输入整数值 -->
<script type="text/javascript">
  function check(form) {
	var regu = /^[1-9]\d*$/;
	if(form.quantity.value=='') {
		alert("数量值不能为空!");
		form.quantity.focus();
		return false;
	}
	if(!regu.test(form.quantity.value)) {
		alert("必须输入正整数!");
		form.quantity.focus();
		return false;
	}
	var s=${product.stock};
	if(form.quantity.value>s){
		alert("库存不足！")
		form.quantity.focus();
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
<form name="myform" method='post' action='product_addToCart' >
   <!--使用隐藏表单域将id请求参数传递给addToCart动作 -->
   <input type='hidden' name='id' value='${product.id}'/>
   <table>
   	<tr><td rowspan='6' align='center'><img src="${product.picture}" width='200'/><br/><a href="product_download?id=${product.id}" style='text-decoration:none'>保存图片</a></td>
      <td>&nbsp;&nbsp;<b>${product.pname}</b></td></tr>
      <tr><td>&nbsp;&nbsp;价格：${product.price}</td></tr>
      <tr><td>&nbsp;&nbsp;库存量：${product.stock}</td></tr>
      <tr><td>&nbsp;&nbsp;请输入购买数量：</td></tr>
      <tr><td>&nbsp;&nbsp;<input type="text" name='quantity' value='1' id='quantity' /></td></tr>
     <tr><td>&nbsp;&nbsp;<input type='submit' value='加入购物车'  onclick="return check(this.form)"/></td></tr>
    </table>
    <hr/>
     <a href='showProduct.jsp'>返回商品列表</a>&nbsp;&nbsp;<a href="showCart.jsp">查看购物车</a>
</form>
</center>
</body>
</html>
