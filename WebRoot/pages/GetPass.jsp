<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<base href="<%=basePath%>">

<title>找回密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/password.css">
<script type="text/javascript" src="js/pass.js"></script>

</head>

<body>
	<div id="d1">
		<img src="images/LOGO.jpg" id="s1">
	</div>
	<div id="d2">
		<table id="t1">
			<tr>
				<td class="td">用户名</td>
				<td><input type="text" style="height:30px;width:200px;" /></td>
			</tr>
			<tr>
				<td class="td">请输入验证码</td>
				<td><input type="text" style="height:30px;width:200px;" /></td>
				<td> <div id="checkCode" class="code"  onclick="createCode(4)" ></div></td>
           	    <td> <input type="button" onclick="createCode(4)" value="看不清换一张" style="height:28px;width:100px;"/></td>
			</tr>
			<tr>
				<td class="td">新密码</td>
				<td><input type="password" style="height:30px;width:200px;" /></td>
			</tr>
			<tr>
				<td class="td">确认新密码</td>
				<td><input type="password" style="height:30px;width:200px;" /></td>
			</tr>


		</table>
		<a href="jsp/homeStart.jsp"><input id="b1" type="button"
			value="保存并登录"></a><br> <a href="jsp/UpdatePass.jsp"><input
			id="b2" type="button" value="修改原密码"></a>
	</div>
</body>
</html>
