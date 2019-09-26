package cn.com.rpg.dao;

import java.util.List;

import cn.com.rpg.entity.recordRpg;

public interface recordRpgDao {
	//查询record_rpg表中所有的信息
	/**
	 * 查询record_rpg表中所有的信息
	 * @return List<recordRpg>
	 */
	public List<recordRpg> selectAll();
	
	//通过id查询存档信息
	/**
	 * 通过id查询存档信息
	 * @param id:int
	 * @return recordRpg
	 */
	public recordRpg selectById(int id);
	
	//通过userId查询存档信息
	/**
	 * 通过用户id查询存档信息
	 * @param userId:int
	 * @return	List<recordRpg>
	 */
	public List<recordRpg> selectByUserId(int userId);
	
	//通过userId和recordType查询信息
	/**
	 * 通过userId和recordType查询信息
	 * @param userId:int
	 * @param recordType:int
	 * @return recordRpg
	 */
	public recordRpg selectByUserIdAndRecordType(int userId,int recordType);
	
	//通过userName查询存档信息
	/**
	 * 通过userName查询存档信息
	 * @param userName:String
	 * @return List<recordRpg>
	 */
	public List<recordRpg> selectByUserName(String userName);
	
	//通过id修改存档信息
	/**
	 * 通过id查询存档信息用于修改
	 * @param id:int
	 * @param record:recordRpg
	 * @return int
	 */
	public int updateInfoById(int id,recordRpg record);
	
	//增加存档
	//(用于复制/备份)
	/**
	 * 增加存档(用于复制/备份)
	 * @param record:recordRpgs
	 * @return int
	 */
	public int addRecord(recordRpg record);
	
	//通过id删除存档
	/**
	 * 通过id删除存档
	 * @param id:int
	 * @return int
	 */
	public int deleteRecordById(int id);
	
	//通过userId删除存档
	//(用于删除用户)
	/**
	 * 通过id删除存档(用于删除用户)
	 * @param userId:int
	 * @return int
	 */
	public int deleteRecordByUserId(int userId);
	
}

