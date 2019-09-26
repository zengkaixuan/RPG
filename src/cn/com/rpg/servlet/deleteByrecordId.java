package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.recordRpgServiceImp;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class deleteByrecordId extends HttpServlet {

	
	public deleteByrecordId() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		System.out.println("����deleteByrecordIdServlet...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("����ִ��doGet����...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("����ִ��doPost����...");
		    recordRpgService recordService = new recordRpgServiceImp();       
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();         
            int a =recordService.deleteRecordById(id);
            if(a>0){
               request.getRequestDispatcher("pages/record2.jsp").forward(request, response);
            }else{
               System.out.println("ɾ���û��浵id:"+id+"ʧ�ܣ�");
            }
	}
	
	
	public void init() throws ServletException {
		System.out.println("deleteByrecordIdServlet��ʼ��...");
	}
	

}
