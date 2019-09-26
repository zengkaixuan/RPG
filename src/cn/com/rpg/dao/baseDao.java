package cn.com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class baseDao {
	//配置信息
	/*private static String url=
			configManager.getConfig().getValue("jdbc.connection.url");
	private static String driver=
			configManager.getConfig().getValue("jdbc.driver_class");
	private static String user=
			configManager.getConfig().getValue("jdbc.connection.user");
	private static String password=
			configManager.getConfig().getValue("jdbc.connection.pass");*/
	//数据库连接变量
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	//连接mysql数据库
	/**
	 * 连接mysql数据库
	 */
	public boolean getConnection(){
		try {
			//获取上下文对象
			Context ctx=new InitialContext();
			
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/rpg");
			conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("无法连接数据库!");
			return false;
		}
		return true;
	}
	
	//关闭所有连接
	/**
	 * 关闭Connection,PreparedStatement,ResultSet对象
	 */
	public void closeAll(){
		try {
			if(conn!=null){
				conn.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//查
	/**
	 * 查询mysql数据库
	 * @param sql:sql语句
	 * @param params:占位符中参数
	 * @return
	 */
	public ResultSet selectSql(String sql,Object[] params){
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;
	}
	
	//增删改
	/**
	 * 增删改mysql数据库
	 * @param sql:sql语句
	 * @param params:占位符中参数
	 * @return
	 */
	public int updateSQL(String sql,Object[] params){
		int a=0;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			a=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return a;
	}
	
}
