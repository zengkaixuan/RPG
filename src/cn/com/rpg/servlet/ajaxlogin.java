package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.rpg.entity.userRpg;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class ajaxlogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		System.out.println("ajax");
		int num = 0;
		//获取登陆框中用户输入的数据
		String name = request.getParameter("User");
		String pwd = request.getParameter("password");
		PrintWriter pw=null;
		System.out.println(name);
		System.out.println(pwd);
		//调用后台根据用户名和密码查询是否存在该用户存档的方法，返回值为int类型；
		userRpgService userService = new userRpgServiceImp();
		//将登陆框中获取的用户名和密码作为参数传入上面调用的方法，于数据库中的内容进行比较；
		//根据返回值判断是否存在该用户信息；若存在则允许登陆，否则，提醒它注册账号
	    num = userService.selectByNameAndPwd(name, pwd);
		if (!(("").equals(name)) && name != null) {
			if ("admin".equals(name) && "admin".equals(pwd)) {
				num=-1;
				pw=response.getWriter();
				pw.print(num);
				pw.flush();
				pw.close();
			} else {
				if (num == 0) {
					System.out.println("用户名或者密码错误！请重新输入");
					pw=response.getWriter();
					pw.print(num);
					pw.flush();
					pw.close();
				} else {
					pw=response.getWriter();
					pw.print(num);
					pw.flush();
					pw.close();
				}
			}
		}else{
			System.out.println("用户名和密码不能为空");
			request.getRequestDispatcher("jsp/home.jsp").forward(
					request, response);
               
		}
	}


}
