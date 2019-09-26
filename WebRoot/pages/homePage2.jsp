<%@page import="cn.com.rpg.entity.areaRpg"%>
<%@page import="cn.com.rpg.serviceImp.areaRpgServiceImp"%>
<%@page import="cn.com.rpg.service.areaRpgService"%>
<%@page import="cn.com.rpg.entity.characterRpg"%>
<%@page import="cn.com.rpg.serviceImp.characterRpgServiceImp"%>
<%@page import="cn.com.rpg.service.characterRpgService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>TOTO的奇妙冒险</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/homePage2.css">
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/LiftEffect.js"></script>
	
	<script type="text/javascript">
		//音乐播放控件
	var flag = true;
	function musicControls() {
		if (flag) {
			$(".musicPlayer").attr("controls", "controls");
			flag = !flag;
		} else {
			$(".musicPlayer").removeAttr("controls", "controls");
			flag = !flag;
		}
	}

	//视频
	function videoControls() {
		$(".video")
				.append(
						"<div class='videoDiv'><div class='closeVideo' onclick='closeVideo()'></div><video class='videoControls' src='video/amour.mp4' controls='controls'></video></div>");
	}
	//关闭视频
	function closeVideo() {
		$(".videoDiv").remove();
	}

	//用户名验证
	var flagUserNameReg = false;
	function checkUser() {
		var user = $("#userName").val();
		var reg = /^[a-zA-Z][a-zA-Z0-9]{3,15}$/;
		if (reg.test(user) == false) {
			$("#userName").css({
				"border" : "2px solid red"
			});
			flagUserNameReg = false;
		} else {
		}
		if (reg.test(user) != false) {
			flagUserNameReg = true;
			$("#userName").css({
				"border" : "2px solid green"
			});
		}
	};
	//密码验证
	var flagPass = false;
	function checkPwd() {
		var pwd = $("#password").val();
		var reg = /^[a-zA-Z0-9]{4,10}$/;
		if (reg.test(pwd) == false) {
			/* $("#mmts").css("display", "block");*/
			flagPass = false;
			$("#password").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (reg.test(pwd) != false) {
			/* $("#mmts").hide();*/
			flagPass = true;
			$("#password").css({
				"border" : "2px solid green"
			});
		}

	};
	//确认密码
	var flagCheck = false;
	function checkPwd2() {
		var pwd = $("#checkPass").val();
		var pwd2 = $("#checkPass").val();
		if (pwd != pwd2) {
			/* $("#qrmm").css("display", "block");*/
			flagCheck = false;
			$("#checkPass").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (pwd == pwd2) {
			/* $("#qrmm").hide();*/
			flagCheck = true;
			$("#checkPass").css({
				"border" : "2px solid green"
			});
		}

	};
	//邮箱验证
	var flagEmail = false;
	function checkEmail() {
		var Email = $("#email").val();
		var reg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
		if (reg.test(Email) == false) {
			/* $("#yxts").css("display", "block");*/
			flagEmail = false;
			$("#email").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (reg.test(Email) != false) {
			/* $("#yxts").hide();*/
			flagEmail = true;
			$("#email").css({
				"border" : "2px solid green"
			});
		}
	};

	//姓名
	function checkName() {
		var Id = $("#d15").val();
		if (Id == "") {
			/* $("#idts").css("display", "block");*/
			flagIdentity = false;
			$("#d15").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (Id != "") {
			/*  $("#idts").hide(); */
			flagIdentity = true;
			$("#d15").css({
				"border" : "2px solid green"
			});
		}
	};

	//身份证验证
	var flagIdentity = false;
	function checkIDcard() {
		var Id = $("#identity").val();
		var reg = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
		if (reg.test(Id) == false) {
			/* $("#idts").css("display", "block");*/
			flagIdentity = false;
			$("#identity").css({
				"border" : "2px solid red"
			});
		} else {
		}
		if (reg.test(Id) != false) {
			/*  $("#idts").hide(); */
			flagIdentity = true;
			$("#identity").css({
				"border" : "2px solid green"
			});
		}
	};
	//点击导航页面滚屏
	$(function() {
		LiftEffect({
			"control1" : ".lift-nav", //侧栏电梯的容器
			"control2" : ".lift", //需要遍历的电梯的父元素
			"target" : [ ".main", ".story", ".character", ".area" ], //监听的内容，注意一定要从小到大输入
			"current" : "current" //选中的样式
		});

	});
	//锚点
	$(function() {
		var speed = 800;//滚动速度
		var h = document.body.clientHeight;
		//回到顶部
		$("#toTop").click(function() {
			$('html,body').animate({
				scrollTop : '0px'
			}, speed);
		});
	});
	//用户名数据库验证
	var flagUserNameSQL = false;
	$(document).ready(function() {
		$("#userName").blur(function() {
			$.get("ajaxZhuCe", {
				User : $("#userName").val()
			}, function(data) {
				if (data == "-1" && flagUserNameReg == true) {
					flagUserNameSQL = false;
					$("#userName").css({
						"border" : "2px solid red"
					});
					alert("用户名已经存在!");
				} else if (data == "1" && flagUserNameReg == true) {
					flagUserNameSQL = true;
					$("#userName").css({
						"border" : "2px solid green"
					});
				}
			});
		});
	});

	//点击注册表单的注册按钮
	$(function() {
		$("#d17").mouseover(
				function() {
					var flags = flagUserNameSQL + flagUserNameReg + flagPass
							+ flagCheck + flagEmail + flagIdentity;
					if (flags == 6) {
						alert("验证成功，请点击注册按钮完成用户注册");
						$("#ZC").empty();
						$("#ZC").append(
								"<input type='submit' value='注册' id='d17'>");
					}
				});
	});
	//鼠标悬停显示地图事件
		$(function() {
			$(".area1").hover(function() {
				$(".xianshi1").show();
				$(".ditujieshao2").show();
			}, function() {
				$(".xianshi1").hide();
				$(".ditujieshao2").hide();
			})
		})

		$(function() {
			$(".area2").hover(function() {
				$(".xianshi2").show();
				$(".ditujieshao3").show();
			}, function() {
				$(".xianshi2").hide();
				$(".ditujieshao3").hide();
			})
		})

		$(function() {
			$(".area3").hover(function() {
				$(".xianshi3").show();
				$(".ditujieshao1").show();
			}, function() {
				$(".xianshi3").hide();
				$(".ditujieshao1").hide();
			})
		})
		
		/*弹出登录框*/
		function login() {
			$(".loginOp").css("display", "block");
		}
		
		function closeLogin(){
			$(".loginOp").css("display", "none");
		}
		
		/*弹出注册框*/
		function register() {
			$(".registerOp").css("display", "block");
		}
		
		function closeRegister(){
			$(".registerOp").css("display", "none");
		}
		
		/*地图*/
		$(function(){
			$(".areaNo").mouseover(function(){
				var i=$(this).attr("value");
				$(".areaShow").append("<img class='areaImg' src='images/homeImgs/dt"+i+".jpg'>");
			});
			$(".areaNo").mouseout(function(){
				$(".areaShow").empty();
			});
		});
		
		/*登陆*/
		$(document).ready(function() {
			$("#login").click(function(){
					$.get("ajaxlogin",{User:$("#user").val(),password:$("#pass").val()}, 	
					function(data) {
						if(data=="-1"){
							window.location ="pages/user2.jsp?userName="+$("#user").val();
						}else if(data=="1"){
							window.location="pages/homeStart2.jsp?userName="+$("#user").val();
						}else{
							$("#user").css({"border":"2px solid red"});
							$("#pass").css({"border":"2px solid red"});
						}
					}) ;
			});
		});
		
		/*注册*/
		$(function(){
			$("#register").click(function(){
					var flags = flagUserNameSQL + flagUserNameReg + flagPass
							+ flagCheck + flagEmail + flagIdentity;
					if (flags == 6) {
						$.post("ZhuCeSuc", {
							"User" : $("#userName").val(),"password":$("#password").val(),"email":$("#email").val(),"identity":$("#identity").val()
						}, function(data) {
							if (data == "0") {
								alert("数据上传出现问题！请联系管理员");
							} else if (data == "1") {
								window.location.href = "pages/homeStart2.jsp?userName="+$("#userName").val();
							}
						});
					}
				});
			});
			
		//点击导航页面滚屏
		$(function() {
			LiftEffect({
				"control1" : ".lift-nav", //侧栏电梯的容器
				"control2" : ".lift", //需要遍历的电梯的父元素
				"target" : [ ".jq1", ".jq2", ".jq3", ".jq4" ], //监听的内容，注意一定要从小到大输入
				"current" : "current" //选中的样式
			});
		});
		
	</script>
  </head>
  
  <body>
  	<div class="main lift-target">
		<div class="logo">
			<img src="images/homeImgs/logo.jpg">
		</div>
		<!-- 首页 -->
		<div class="pageIndex jq1">
			<div class="music">
 				<audio class="musicPlayer" src="music/music.mp3" autoplay="autoplay" loop="loop"></audio>
 				<br/>
 				<div class="musicInfo" onclick="musicControls()">
 					<span>正在播放:~水の証 ~</span>
 				</div>
			</div>
			<div class="video fl">
				<img src="images/homeImgs/video.png"  onclick="videoControls()">
			</div>
			<div class="indexRight fl">
				<div class="login" onclick="login()">
					<img src="images/homeImgs/login.png">
				</div>
				<div class="register" onclick="register()">
					<img src="images/homeImgs/register.png">
				</div>
			</div>
		</div>
		
		<!--隐藏的登录框 -->
			<div class="loginOp fl">
				<div class="loginClose" onclick="closeLogin()"></div>
				<div class="loginHead">
				</div>
				<div class="loginBody">
					<table class="tableDL">
						<tr>
							<td class="key">用户名</td>
							<td class="input"><input id="user" name="User"></td>
							<td></td>
						</tr>
						<tr>
							<td class="key">密&emsp;码</td>
							<td class="input"><input type="password" id="pass" name="password"></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3"><span id="login" class="loginBt">登陆</span></td>
						</tr>
					</table>
				</div>
			</div>
		<!--隐藏的注册框-->
			<div class="registerOp fl">
				<div class="registerClose" onclick="closeRegister()"></div>
				<div class="registerHead">
				</div>
				<div class="registerBody">
					<table class="tableZC">
						<tr>
							<td class="key" >用户名</td>
							<td class="input"><input placeholder="请输入4-16位，首位为字母" id="userName" name="userName" onblur="checkUser()"></td>
							<td></td>
						</tr>
						<tr>
							<td class="key" >密码</td>
							<td class="input"><input placeholder="请输入4-10位" type="password" id="password" name="password" onblur="checkPwd()"></td>
							<td></td>
						</tr>
						<tr>
							<td class="key">确认密码</td>
							<td class="input"><input type="password" id="checkPass" name="checkPass" onblur="checkPwd2()"></td>
							<td></td>
						</tr>
						<tr>
							<td class="key">邮箱</td>
							<td class="input"><input id="email" name="email" onblur="checkEmail()"></td>
							<td></td>
						</tr>
						<tr>
							<td class="key">身份证</td>
							<td class="input"><input id="identity" name="identity" onblur="checkIDcard()"></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3"><span id="register" class="registerBt">注册</span></td>
						</tr>
					</table>
				</div>
			</div>
			
		<!-- 故事背景  -->
		<div class="story jq2">
		
		</div>
		<!-- 人物介绍 -->
		<% 
			characterRpgService characterService=new characterRpgServiceImp();
			characterRpg character1=characterService.selectById(1);
			characterRpg character2=characterService.selectById(2);
		%>
		<div class="character jq3">
			<div class="chDiv1 fl">
				<div class="chImg1 fl">
					<img alt="" src="images/homeImgs/rw3.png">
				</div>
				<div class="chInfo1 text fr">
					<%=character1.getProfile() %>
				</div>
			</div>
			<div class="chDiv2 fr">
				<div class="chImg2 fr">
					<img alt="" src="images/homeImgs/rw4.png">
				</div>
				<div class="chInfo2 text fl">
					<%=character2.getProfile() %>
				</div>
			</div>
		</div>
		<!-- 地图介绍 --> 
		<%
			areaRpgService areaService=new areaRpgServiceImp();
			areaRpg area1=areaService.selectById(2);
			areaRpg area2=areaService.selectById(3);
			areaRpg area3=areaService.selectById(4);
		 %>
		<div class="area jq4">
			<div id="area1" class="areaNo fl" value="1"></div>
			<div id="area2" class="areaNo fl" value="2"></div>
			<div id="area3" class="areaNo fl" value="3"></div>
			<div class="areaShow fl"></div>
		</div>
  	</div>
  	
  	<!-- 左侧导航 -->
  	<div class="lift-nav">
			<ul class="lift">
				<li><img class="xs5" src="images/homeImgs/index.png"></li>
				<li><img class="xs5" src="images/homeImgs/backStroy.png"></li>
				<li><img class="xs5" src="images/homeImgs/characterInfo.png"></li>
				<li><img class="xs5" src="images/homeImgs/areaInfo.png"></li>			
			</ul>
	</div>
  </body>
</html>