
<%@page import="cn.com.rpg.entity.areaRpg"%>
<%@page import="cn.com.rpg.serviceImp.areaRpgServiceImp"%>
<%@page import="cn.com.rpg.service.areaRpgService"%>
<%@page import="cn.com.rpg.util.limitList"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<title>admin</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin2.css" />
<style type="text/css">

</style>
<script>
	/* 用于页面跳转 */
	function ct() {
		window.location ="pages/record2.jsp";
	}
	function yh() {
		window.location = "pages/user2.jsp";
	}
	function zj() {
		window.location = "pages/character2.jsp";
	}
	function xw() {
		window.location = "pages/news2.jsp";
	}
	function dt() {
		window.location = "pages/area2.jsp";
	}
	function home() {
		window.location = "pages/homePage2.jsp";
	}
		
	function cutStr(len){
		var obj=document.getElementById('table').getElementsByClassName('summary');
		for (i=0;i<obj.length;i++){
			if(obj[i].innerHTML.length>len){
				obj[i].innerHTML=obj[i].innerHTML.substring(0,len)+'…';
			}
		}
	}
</script>
</head>
<body onload="cutStr(15)">
<div class="main">	
	<div class="logo">
			<img src="images/adminImgs/logo.jpg" onclick="home()">
	</div>
	<div class="pageIndex">
		<div class="pageLeft fl">
			<ul>
				<li>
					<input class="userInfo" type="button" value="用户数据" onclick="yh()"> 
				</li>
				<li>	
					<input class="recordInfo" type="button" value="存档数据" onclick="ct()"> 
				</li>
				<li>
					<input class="newsInfo" type="button" value="新闻数据" onclick="xw()"> 
				</li>
				<li>
					<input class="characterInfo" type="button" value="主角介绍" onclick="zj()">
				</li>
				<li>
					<input class="areaInfo" type="button" value="地图数据" onclick="dt()">
				</li>
			</ul>
		</div>
		<div class="pageRight fl">
			<div class="dataTable">
				<table class="table" id="table">
					<tr>
						<!-- <th>id</th> -->
						<th>areaName</th>
						<th>type</th>
						<th>summary</th>			
						<th>操作</th>
					</tr>
					<%
					    /* 分页 */
						//获取当前的页码值
		                String pageNo = request.getParameter("pageNo");
		                //说明首次访问该页面，则给一个默认值
		                if(pageNo==null){
		                     pageNo="1";
		                    }
		                int pageIndex=Integer.valueOf(pageNo);
		                //调用分页类的方法				
					    areaRpgService area = new areaRpgServiceImp();
					    List<areaRpg> list = area.selectAll();
					    limitList<areaRpg> limite = new limitList<areaRpg>(list,8);
					    //获取总页数
						int pageToal = limite.getPageTotal();
						//获取每页显示的内容的集合
						List<areaRpg> newList = limite.limitListElement(pageIndex);
						//遍历集合
						for (areaRpg areaRpg : newList) {
					%>
					<tr>
						<%-- <td><%=areaRpg.getId() %></td> --%>
						<td><%=areaRpg.getAreaName()%></td>
						<td><%=areaRpg.getType()%></td>
						<td class="summary"><%=areaRpg.getSummary()%></td>							   
					    <td><input type="button" value="修改"><br><br>
					    <a href="javascript:if(confirm('确认是否删除此数据？'))location='<%=request.getContextPath()%>/deleteByAreaId?id=<%=areaRpg.getId()%>'"><input type="button" value="删除"></a>
					    </td>
						<%
							}
						%>
					</tr>				
				</table>  		
			</div>
	<!-- 分页查询  -->	
	     <div class="pageNum">
			<ul class="pageInfo">
				<li class="pageToal fl"><%=pageIndex %>/<%=pageToal %>页</li>
					<%
					if(pageIndex>1){				      				  				
					%>
					<li class="firstPage pages fl"><a href="/RPG/pages/area2.jsp?pageNo=<%=1%>">首页</a></li>
					<li class="pageUp pages fl"><a href="/RPG/pages/area2.jsp?pageNo=<%=pageIndex-1%>">上一页</a></li>
					<%}else{%>
					<li class="firstPage pages fl"></li>
					<li class="pageUp pages fl"></li>
					<%}%>
					<%for(int i=1;i<=pageToal;i++){ %>
					<li class="pagesNo pages fl"><a href="/RPG/pages/area2.jsp?pageNo=<%=i%>"><%=i %></a></li>		
					<%} %>
					
					<%
					if(pageIndex<pageToal){
					%>
					<li class="pageDown pages fl"><a href="/RPG/pages/area2.jsp?pageNo=<%=pageIndex+1%>">下一页</a></li>
					<li class="lastPage pages fl"><a href="/RPG/pages/area2.jsp?pageNo=<%=pageToal%>">尾页</a></li>
					<%} %>
			</ul>
		</div>
	</div>
	</div>
</div>
</body>
</html>