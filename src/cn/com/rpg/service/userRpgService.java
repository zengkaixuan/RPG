package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.userRpg;

public interface userRpgService {
	
	//��ѯuser_rpg�������е��û�
	/**
	 * ��ѯuser_rpg�������е��û�
	 * @return List<userRpg>:List
	 */
	public List<userRpg> selectAll();
		
	//ͨ��id��ѯ�û�
	/**
	 * ͨ��id��ѯ�û�
	 * @param id:int
	 * @return userRpg:userRpg
	 */
	public userRpg selectById(int id);
	
	//ͨ���û�����ѯ�û�
	/**
	 * ͨ���û�����ѯ�û�
	 * @param UserName:String
	 * @return userRpg:userRpg
	 */
	public userRpg selectByUserName(String UserName);
	
	//ͨ���û����Ͳ�ѯ�û�
	/**
	 * ͨ���û����Ͳ�ѯ�û�
	 * @param userType:int
	 * @return List<userRpg>:List
	 */
	public List<userRpg> selectByUserType(int userType);
	
	//ͨ��vip��ѯ�û�
	/**
	 * ͨ��vip��ѯ�û�
	 * @param vip:int
	 * @return List <userRpg>:List
	 */
	public List<userRpg> selectByVip(int vip);
	
	//ͨ��id��ѯ�û������޸��û���Ϣ
	/**
	 * ͨ��id��ѯ�û������޸��û���Ϣ
	 * @param id:int
	 * @param user:userRpg
	 * @return int
	 */
	public int updateInfoById(int id,userRpg user);
	
	//�����û�
	/**
	 * 
	 * @param user:userRpg
	 * @return int
	 */
	public int addUser(userRpg user);
	
	//ͨ��idɾ���û�
	/*
	 * ��Ϊrecord_rpg���е�userIdΪuser_rpg����id�����,
	 * ����Ҫ��ɾ��record_rpg���и�userId��������Ϣ
	 */
	/**
	 * ͨ��idɾ���û�
	 * @param id:int
	 * @return int
	 */
	public int deleteUser(int id);
	
	//�����û���Ϣ
	public boolean insertUser(userRpg user);
	
	//ͨ���û����������ѯ�û�
 	/**
 	 * ͨ���û�����ѯ�û�
 	 * @param UserName:String
 	 * @return userRpg:userRpg
 	 */
	public int selectByNameAndPwd(String userName,String password);
	
	
}
