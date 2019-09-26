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
	<link rel="stylesheet" type="text/css" href="css/homeStart2.css">
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		//音乐播放控件
		var flag=true;
		function musicControls(){
			if(flag){
				$(".musicPlayer").attr("controls","controls");
				flag=!flag;
			}else{
				$(".musicPlayer").removeAttr("controls","controls");
				flag=!flag;
			}
		}
		
		//开始游戏
		function start(){
			var userName=$(".userName").val();
			window.location ="pages/loadData.jsp?userName="+userName;
		}
		
		//返回首页
		function returnHome(){
			window.location.href="pages/homePage2.jsp";
		}
		//修改密码
		function updatePass(){
			var userName=$(".userName").val();
			window.location.href="pages/updatePass.jsp?userName="+userName;
		}
	</script>
  </head>
  
  <body>
	<div class="main">
		<div class="logo">
			<img src="images/startImgs/logo.jpg">
		</div>
		<!-- 首页 -->
		<div class="pageIndex">
			<div class="music">
 				<audio class="musicPlayer" src="music/music.mp3" autoplay="autoplay" loop="loop"></audio>
 				<br/>
 				<div class="musicInfo" onclick="musicControls()">
 					<span>正在播放:~水の証 ~</span>
 				</div>
			</div>
			<div class="indexRight fl">
				<input type="hidden" class="userName" value="<%=request.getParameter("userName") %>">
				<div class="start" onclick="start()">
					<img src="images/startImgs/start.png">
				</div>
				<div class="welcome text">
					<h4>欢迎<br/>&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getParameter("userName") %><br/>来到TOTO的奇幻冒险!</h4>
				</div>
				<div class="returnHome" onclick="returnHome()">
					<img src="images/startImgs/returnHome.png">
				</div>
				<div class="updatePass" onclick="updatePass()">
					<img src="images/startImgs/updatePass.png">
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" class="userName" value="<%=request.getParameter("userName") %>">
  </body>
</html>
