package cn.com.rpg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.dao.userRpgDao;
import cn.com.rpg.daoImp.userRpgDaoImp;
import cn.com.rpg.entity.userRpg;

public class userCreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("销毁userCreateServlet...");
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
		//获取用户名
		String userName=request.getParameter("userName");
		//获取密码
		String password=request.getParameter("password");
		//获取邮箱
		String email=request.getParameter("email");
		//获取身份证
		String identity=request.getParameter("identity");
		//写入数据库
		userRpg user=new userRpg();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setIdentity(identity);
		user.setUserType(1);
		user.setVip(0);
		userRpgDao userDao=new userRpgDaoImp();
		userDao.addUser(user);
		response.sendRedirect("/RPG/pages/success.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("userCreateServlet初始化...");
	}

}
