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
<title>会员管理</title>
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
<form action="vip_search?flag=0" method="post">
<input type="text" name="vname" />
<input type="submit" value="查找会员"/>
</form>

<br>
<a href="addVip.jsp">点击添加会员</a>
<br><br>
<table border='1'>
     <tr>
       <td>会员序号</td><td>姓名</td><td>性别</td><td>会员等级</td><td>会员积分</td><td>联系方式</td><td colspan='2'>操作</td>
     </tr>
    <demo:showVip vipList="${vipList}">
     <tr>
    <td>${vip.vid}</td>
     	<td>${vip.vname}</td>
     	<td>${vip.gender}</td>
       <td>${vip.level}</td>
       <td>${vip.points}</td>
       <td>${vip.tele}</td>
       <td><a href="vip_delete?vid=${vip.vid}" onClick="return del()">删除</a></td>
       <td><a href="vip_alter?vid=${vip.vid}">修改</a></td>
     </tr>
    </demo:showVip>
  </table>
  <br/>
  <a href="admin.jsp">返回首页</a>
</body>
</html>