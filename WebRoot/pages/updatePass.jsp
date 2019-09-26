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

<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/updatePass.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//旧密码验证
	var flagOldPass=false;
	function passSQL() {
		$.get("ajaxOldPass", {
				User : $(".userName").val(), oldPass:$(".oldPass").val()
			}, function(data) {
				if (data == "0") {
					flagOldPass = false;
					$(".oldPass").css({"border" : "2px solid red"});
					alert("原密码错误！");
				} else if (data == "1") {
					flagOldPass = true;
					$(".oldPass").css({"border" : "2px solid green"});
			}
		});
	}
	//新密码验证
	var flagPass = false;
	function checkPwd() {
		var pwd = $(".newPass").val();
		var reg = /^[a-zA-Z0-9]{4,10}$/;
		if (reg.test(pwd) == false) {
			/* $("#mmts").css("display", "block");*/
			flagPass = false;
			$(".newPass").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (reg.test(pwd) != false) {
			/* $("#mmts").hide();*/
			flagPass = true;
			$(".newPass").css({
				"border" : "2px solid green"
			});
		}
	};
	//再次输入密码
	var flagCheck = false;
	function checkPwd2() {
		var pwd = $(".checkPass").val();
		var reg = $(".newPass").val();
		if (reg!=pwd) {
			/* $("#mmts").css("display", "block");*/
			flagCheck = false;
			$(".checkPass").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (reg==pwd) {
			/* $("#mmts").hide();*/
			flagCheck = true;
			$(".checkPass").css({
				"border" : "2px solid green"
			});
		}
	};
	
	//修改密码
	function updatePass(){
		var flag=flagOldPass+flagPass+flagCheck;
		if(flag==3){
			$.get("updatePass", {
				User : $(".userName").val(), newPass:$(".newPass").val()
			}, function(data) {
				if (data == "0") {
					flagOldPass = false;
					$(".oldPass").css({"border" : "2px solid red"});
					alert("更新密码失败！请联系管理员");
				} else if (data == "1") {
					flagOldPass = true;
					$(".oldPass").css({"border" : "2px solid green"});
					alert("修改密码成功！");
					window.location.href="pages/homePage2.jsp";
				}
			});
		}
	}
</script>
</head>

<body>
	<div class="main">
		<div class="logo">
			<img src="images/passOperate/logo.jpg">
		</div>
		<div class="pageIndex">
		<div class="operate fl">
			<div class="operateTop">
			</div>
			<div class="tableBg">
				<table class="table">
				<tr>
					<td class="key">原密码</td>
					<td class="input"><input class="oldPass" type="password" name="oldPass" onblur="passSQL()"/></td>
				</tr>
				<tr>
					<td class="key">新密码</td>
					<td  class="input"><input placeholder="请输入4-10位" class="newPass" type="password" name="newPass" onblur="checkPwd()"/></td>
				</tr>
				<tr>
					<td class="key">确认新密码</td>
					<td class="input"><input class="checkPass" type="password" onblur="checkPwd2()"/></td>
				</tr>
				<tr>
					<td colspan="2"><span class="check" onclick="updatePass()">修改并登录</span></td>
				</tr>
				</table>
			</div>
			</div>
		</div>
	</div>
	<input type="hidden" class="userName" name="userName" value="<%=request.getParameter("userName") %>">
</body>
</html>
