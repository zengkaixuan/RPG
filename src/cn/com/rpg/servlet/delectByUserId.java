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
		System.out.println("����deleteServlet...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("����ִ��doGet����...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("����ִ��doPost����...");
			//����service������û�idɾ���û����ݵķ���������ɾ�����ͨ������д�����ݿ�
			userRpgService userService = new userRpgServiceImp();  		 
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();  
            int a =userService.deleteUser(id);
            if(a>0){
               request.getRequestDispatcher("pages/user2.jsp").forward(request, response);
            }else{
               System.out.println("ɾ���û�id:"+id+"ʧ�ܣ�");
            }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("deleteServlet��ʼ��...");
	}
	
	

}
