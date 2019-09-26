package cn.com.rpg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.rpg.entity.recordRpg;
import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.serviceImp.recordRpgServiceImp;

public class dataSave extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
		System.out.println("销毁dataSaveServlet...");
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
		System.out.println("正在执行doGet方法...");
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
		System.out.println("正在执行doPost方法...");
		//获取data的值
		String data=request.getParameter("data");
		data=data.replace(" ", "+");
		//获取userId
		int userId=Integer.valueOf(request.getParameter("userId")).intValue();
		//获取userName
		String userName=request.getParameter("userName");
		/*System.out.println(userId+"+"+userName);*/
		int recordType;
		//创建一个boolean型变量,用来给会掉函数做响应信息
		int flag=0;//默认是false
		//通过name值去查询数据库,看是否存在信息
		recordRpgService recordService=new recordRpgServiceImp();
		recordRpg record=new recordRpg();
		record.setUserId(userId);
		record.setUserName(userName); 
		String checkType=data.substring(0,2);
		if(checkType.equals("No")){
			record.setRecordType(0);
			recordType=0;
		}else{
			record.setRecordType(1);
			recordType=1;
		}
		record.setDataValue(data);
		recordRpg checkRecord=recordService.selectByUserIdAndRecordType(userId, recordType);
		System.out.println(checkRecord);
		if(checkRecord==null){
			flag=recordService.addRecord(record);
		}else{
			int id=checkRecord.getId();
			flag=recordService.updateInfoById(id, record);
		}
		System.out.println(data);
		//将flag响应出去
		PrintWriter pw=response.getWriter();
		pw.print(flag);//使用流写出
		pw.flush();//强制写出
		pw.close();//关闭流
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("dataSaveServlet初始化...");
	}

}
