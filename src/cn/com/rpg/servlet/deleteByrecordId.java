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
		System.out.println("销毁deleteByrecordIdServlet...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("正在执行doGet方法...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("正在执行doPost方法...");
		    recordRpgService recordService = new recordRpgServiceImp();       
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();         
            int a =recordService.deleteRecordById(id);
            if(a>0){
               request.getRequestDispatcher("pages/record2.jsp").forward(request, response);
            }else{
               System.out.println("删除用户存档id:"+id+"失败！");
            }
	}
	
	
	public void init() throws ServletException {
		System.out.println("deleteByrecordIdServlet初始化...");
	}
	

}
