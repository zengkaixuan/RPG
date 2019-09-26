package cn.com.rpg.dao;

import java.util.List;

import cn.com.rpg.entity.recordRpg;

public interface recordRpgDao {
	//��ѯrecord_rpg�������е���Ϣ
	/**
	 * ��ѯrecord_rpg�������е���Ϣ
	 * @return List<recordRpg>
	 */
	public List<recordRpg> selectAll();
	
	//ͨ��id��ѯ�浵��Ϣ
	/**
	 * ͨ��id��ѯ�浵��Ϣ
	 * @param id:int
	 * @return recordRpg
	 */
	public recordRpg selectById(int id);
	
	//ͨ��userId��ѯ�浵��Ϣ
	/**
	 * ͨ���û�id��ѯ�浵��Ϣ
	 * @param userId:int
	 * @return	List<recordRpg>
	 */
	public List<recordRpg> selectByUserId(int userId);
	
	//ͨ��userId��recordType��ѯ��Ϣ
	/**
	 * ͨ��userId��recordType��ѯ��Ϣ
	 * @param userId:int
	 * @param recordType:int
	 * @return recordRpg
	 */
	public recordRpg selectByUserIdAndRecordType(int userId,int recordType);
	
	//ͨ��userName��ѯ�浵��Ϣ
	/**
	 * ͨ��userName��ѯ�浵��Ϣ
	 * @param userName:String
	 * @return List<recordRpg>
	 */
	public List<recordRpg> selectByUserName(String userName);
	
	//ͨ��id�޸Ĵ浵��Ϣ
	/**
	 * ͨ��id��ѯ�浵��Ϣ�����޸�
	 * @param id:int
	 * @param record:recordRpg
	 * @return int
	 */
	public int updateInfoById(int id,recordRpg record);
	
	//���Ӵ浵
	//(���ڸ���/����)
	/**
	 * ���Ӵ浵(���ڸ���/����)
	 * @param record:recordRpgs
	 * @return int
	 */
	public int addRecord(recordRpg record);
	
	//ͨ��idɾ���浵
	/**
	 * ͨ��idɾ���浵
	 * @param id:int
	 * @return int
	 */
	public int deleteRecordById(int id);
	
	//ͨ��userIdɾ���浵
	//(����ɾ���û�)
	/**
	 * ͨ��idɾ���浵(����ɾ���û�)
	 * @param userId:int
	 * @return int
	 */
	public int deleteRecordByUserId(int userId);
	
}

