<%@page import="cn.com.rpg.entity.userRpg"%>
<%@page import="cn.com.rpg.serviceImp.userRpgServiceImp"%>
<%@page import="cn.com.rpg.service.userRpgService"%>
<%@page import="cn.com.rpg.serviceImp.recordRpgServiceImp"%>
<%@page import="cn.com.rpg.service.recordRpgService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'data.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="js/jquery-1.12.4.js"></script>
    <script>
        $(function(){
            if(!window.localStorage){
                alert("浏览器支持localstorage");
                return false;
            }else{
                var storage=window.localStorage;
                if($("#File1").val()==null){
                	 localStorage.removeItem('userinfo');
        			 console.log(localStorage.getItem('userinfo'));
                }
                storage["RPG File1"]=$("#File1").val();
                storage["RPG Global"]=$("#Global").val();
                window.location=$("#url").val();
            }
        });
    </script>
  </head>
  
  <body>
	<% 
		userRpgService userService=new userRpgServiceImp();
		String userName=request.getParameter("userName"); 
		userRpg user=userService.selectByUserName(userName);
		int userId=user.getId();
		recordRpgService recordService=new recordRpgServiceImp();
		String Global=null;
		String File1=null;
		if(recordService.selectByUserIdAndRecordType(userId, 0)!=null){
			Global=recordService.selectByUserIdAndRecordType(userId, 0).getDataValue();
			File1=recordService.selectByUserIdAndRecordType(userId, 1).getDataValue();
		}
		String url="www/index.html?userId="+userId+"&&userName="+userName;
	%>  
  	
  	<input type="hidden" id="Global" value="<%=Global  %>">
  	<input type="hidden" id="File1" value="<%=File1  %>">
  	<input type="hidden" id="url" value="<%=url  %>">
  </body>
</html>
