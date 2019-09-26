package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.userRpg;

public interface userRpgService {
	
	//查询user_rpg表中所有的用户
	/**
	 * 查询user_rpg表中所有的用户
	 * @return List<userRpg>:List
	 */
	public List<userRpg> selectAll();
		
	//通过id查询用户
	/**
	 * 通过id查询用户
	 * @param id:int
	 * @return userRpg:userRpg
	 */
	public userRpg selectById(int id);
	
	//通过用户名查询用户
	/**
	 * 通过用户名查询用户
	 * @param UserName:String
	 * @return userRpg:userRpg
	 */
	public userRpg selectByUserName(String UserName);
	
	//通过用户类型查询用户
	/**
	 * 通过用户类型查询用户
	 * @param userType:int
	 * @return List<userRpg>:List
	 */
	public List<userRpg> selectByUserType(int userType);
	
	//通过vip查询用户
	/**
	 * 通过vip查询用户
	 * @param vip:int
	 * @return List <userRpg>:List
	 */
	public List<userRpg> selectByVip(int vip);
	
	//通过id查询用户用于修改用户信息
	/**
	 * 通过id查询用户用于修改用户信息
	 * @param id:int
	 * @param user:userRpg
	 * @return int
	 */
	public int updateInfoById(int id,userRpg user);
	
	//增加用户
	/**
	 * 
	 * @param user:userRpg
	 * @return int
	 */
	public int addUser(userRpg user);
	
	//通过id删除用户
	/*
	 * 因为record_rpg表中的userId为user_rpg表中id的外键,
	 * 所以要先删除record_rpg表中该userId的所有信息
	 */
	/**
	 * 通过id删除用户
	 * @param id:int
	 * @return int
	 */
	public int deleteUser(int id);
	
	//插入用户信息
	public boolean insertUser(userRpg user);
	
	//通过用户名和密码查询用户
 	/**
 	 * 通过用户名查询用户
 	 * @param UserName:String
 	 * @return userRpg:userRpg
 	 */
	public int selectByNameAndPwd(String userName,String password);
	
	
}
