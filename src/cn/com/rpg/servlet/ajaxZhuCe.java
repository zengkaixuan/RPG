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

public class ajaxZhuCe extends HttpServlet {

	public ajaxZhuCe() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = 0;
		 //ʵ���û�ע���ύ�����ݿ� 
		// ��ȡ�û���ȷ���ע��ʱ���������
		String userName = request.getParameter("User");
		PrintWriter pw = null;
		// ���ú�̨�����û�����ѯ�Ƿ���ڸ��û����ظ�
		userRpgService userService = new userRpgServiceImp();
		userRpg user = userService.selectByUserName(userName);
		System.out.println(user);
		if (user==null) {
			num=1;
			pw=response.getWriter();
			pw.print(num);
			pw.flush();
			pw.close();
		} else {
			num=-1;
			pw=response.getWriter();
			pw.print(num);
			pw.flush();
			pw.close();
		}

	}

	public void init() throws ServletException {

	}

}
