package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.serviceImp.recordRpgServiceImp;

public class copyRecord extends HttpServlet {

	public copyRecord() {
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
            int id = Integer.valueOf(request.getParameter("id"));
            //调用备份的方法
            recordRpgService recordService = new recordRpgServiceImp();
            int a = recordService.copyRecord(id);
		    if(a>0){
		    	 response.sendRedirect("pages/record2.jsp");
		    }else{
		    	System.out.println("备份失败");
		    }
	}

	
	public void init() throws ServletException {
		
	}

}
