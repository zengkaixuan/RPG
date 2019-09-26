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
		System.out.println("����deleteBycharacterId...");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("����ִ��doGet����...");
            doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("����ִ��doPost����...");
		    characterRpgService characterService = new characterRpgServiceImp();       
            int id=Integer.valueOf(request.getParameter("id").trim()).intValue();         
            int a =characterService.deleteCharacterById(id);
            if(a>0){
               request.getRequestDispatcher("pages/character2.jsp").forward(request, response);
            }else{
               System.out.println("ɾ������id:"+id+"ʧ�ܣ�");
            }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("deleteBycharacterId��ʼ��...");
	}

}
