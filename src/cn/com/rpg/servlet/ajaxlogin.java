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
		//��ȡ��½�����û����������
		String name = request.getParameter("User");
		String pwd = request.getParameter("password");
		PrintWriter pw=null;
		System.out.println(name);
		System.out.println(pwd);
		//���ú�̨�����û����������ѯ�Ƿ���ڸ��û��浵�ķ���������ֵΪint���ͣ�
		userRpgService userService = new userRpgServiceImp();
		//����½���л�ȡ���û�����������Ϊ��������������õķ����������ݿ��е����ݽ��бȽϣ�
		//���ݷ���ֵ�ж��Ƿ���ڸ��û���Ϣ���������������½������������ע���˺�
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
					System.out.println("�û������������������������");
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
			System.out.println("�û��������벻��Ϊ��");
			request.getRequestDispatcher("jsp/home.jsp").forward(
					request, response);
               
		}
	}


}
