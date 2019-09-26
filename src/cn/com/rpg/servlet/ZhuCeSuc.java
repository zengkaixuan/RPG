package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.entity.userRpg;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class ZhuCeSuc extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("正在执行doGet方法...");
		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("正在执行doPost方法...");
		PrintWriter pw = null;
		//获取用户名
		String userName=request.getParameter("User");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String idc=request.getParameter("identity");
		userRpgService userService=new userRpgServiceImp();
		userRpg user=new userRpg();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setIdentity(idc);
		int a=userService.addUser(user);
		pw=response.getWriter();
		pw.print(a);
		pw.flush();
		pw.close();
	}

}
