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

public class userNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("����servlet...");
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
		System.out.println("����ִ��doGet����...");
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
		System.out.println("����ִ��doPost����...");
		//��ȡ�û���
		String userName=request.getParameter("userName");
		//����һ��boolean�ͱ���,Ĭ����false,�����������������Ӧ��Ϣ
		boolean flag=false;
		//ȥ�����ݿ�����������ƥ��
		userRpgService userService=new userRpgServiceImp();
		userRpg user=userService.selectByUserName(userName);
		if(user!=null){
			flag=true;
		}
		//��flag��Ӧ��ȥ
		PrintWriter pw=response.getWriter();
		pw.print(flag);//ʹ����д��
		pw.flush();//ǿ��д��
		pw.close();//�ر���
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("userNameServlet��ʼ��...");
	}

}
