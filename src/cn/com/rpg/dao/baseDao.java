package cn.com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class baseDao {
	//������Ϣ
	/*private static String url=
			configManager.getConfig().getValue("jdbc.connection.url");
	private static String driver=
			configManager.getConfig().getValue("jdbc.driver_class");
	private static String user=
			configManager.getConfig().getValue("jdbc.connection.user");
	private static String password=
			configManager.getConfig().getValue("jdbc.connection.pass");*/
	//���ݿ����ӱ���
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	//����mysql���ݿ�
	/**
	 * ����mysql���ݿ�
	 */
	public boolean getConnection(){
		try {
			//��ȡ�����Ķ���
			Context ctx=new InitialContext();
			
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/rpg");
			conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�޷��������ݿ�!");
			return false;
		}
		return true;
	}
	
	//�ر���������
	/**
	 * �ر�Connection,PreparedStatement,ResultSet����
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
	
	//��
	/**
	 * ��ѯmysql���ݿ�
	 * @param sql:sql���
	 * @param params:ռλ���в���
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
	
	//��ɾ��
	/**
	 * ��ɾ��mysql���ݿ�
	 * @param sql:sql���
	 * @param params:ռλ���в���
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
