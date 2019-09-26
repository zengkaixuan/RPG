package cn.com.rpg.serviceImp;

import java.util.List;

import cn.com.rpg.dao.recordRpgDao;
import cn.com.rpg.dao.userRpgDao;
import cn.com.rpg.daoImp.recordRpgDaoImp;
import cn.com.rpg.daoImp.userRpgDaoImp;
import cn.com.rpg.entity.recordRpg;
import cn.com.rpg.service.recordRpgService;

public class recordRpgServiceImp implements recordRpgService{
	userRpgDao userDao;
	recordRpgDao recordDao;
	
	public recordRpgServiceImp() {
		userDao=new userRpgDaoImp();
		recordDao=new recordRpgDaoImp();
	}

	//��ѯrecord_rpg�������е���Ϣ
	public List<recordRpg> selectAll() {
		return recordDao.selectAll();
	}

	//ͨ��id��ѯ�浵��Ϣ
	public recordRpg selectById(int id) {
		return recordDao.selectById(id);
	}

	//ͨ��userId��ѯ�浵��Ϣ
	public List<recordRpg> selectByUserId(int userId) {
		return recordDao.selectByUserId(userId);
	}
	
	//ͨ��userId��recordType��ѯ��Ϣ
	public recordRpg selectByUserIdAndRecordType(int userId,int recordType){
		return recordDao.selectByUserIdAndRecordType(userId, recordType);
	}

	//ͨ��userName��ѯ�浵��Ϣ
	public List<recordRpg> selectByUserName(String userName) {
		return recordDao.selectByUserName(userName);
	}

	//ͨ��id��ѯ�浵��Ϣ�����޸�
	public int updateInfoById(int id, recordRpg record) {
		return recordDao.updateInfoById(id, record);
	}

	//���Ӵ浵
	//(���ڸ���/����)
	public int addRecord(recordRpg record) {
		return recordDao.addRecord(record);
	}
	
	//���ơ����ݴ浵
	public int copyRecord(int id){
		recordRpg record=recordDao.selectById(id);
		recordRpg newRecord=new recordRpg();
		newRecord.setUserId(record.getUserId());
		newRecord.setUserName(record.getUserName());
		newRecord.setRecordType(record.getRecordType());
		newRecord.setDataValue(record.getDataValue());
		return recordDao.addRecord(newRecord);
	}

	//ͨ��idɾ���浵
	public int deleteRecordById(int id) {
		return recordDao.deleteRecordById(id);
	}

	//ͨ��userIdɾ���浵
	//(����ɾ���û�)
	public int deleteRecordByUserId(int userId) {
		return recordDao.deleteRecordByUserId(userId);
	}
	
}
