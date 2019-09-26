package cn.com.rpg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.recordRpgServiceImp;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class delectByUserId extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("销毁deleteServlet...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("正在执行doGet方法...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("正在执行doPost方法...");
			//调用service层根据用户id删除用户数据的方法，并将删除结果通过后天写入数据库
			userRpgService userService = new userRpgServiceImp();  		 
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();  
            int a =userService.deleteUser(id);
            if(a>0){
               request.getRequestDispatcher("pages/user2.jsp").forward(request, response);
            }else{
               System.out.println("删除用户id:"+id+"失败！");
            }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("deleteServlet初始化...");
	}
	
	

}
