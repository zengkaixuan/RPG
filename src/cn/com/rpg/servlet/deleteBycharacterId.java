package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.service.characterRpgService;
import cn.com.rpg.service.userRpgService;
import cn.com.rpg.serviceImp.characterRpgServiceImp;
import cn.com.rpg.serviceImp.userRpgServiceImp;

public class deleteBycharacterId extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteBycharacterId() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		System.out.println("销毁deleteBycharacterId...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("正在执行doGet方法...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("正在执行doPost方法...");
		    characterRpgService characterService = new characterRpgServiceImp();       
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();         
            int a =characterService.deleteCharacterById(id);
            if(a>0){
               request.getRequestDispatcher("pages/character2.jsp").forward(request, response);
            }else{
               System.out.println("删除人物id:"+id+"失败！");
            }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("deleteBycharacterId初始化...");
	}

}
