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

	//查询record_rpg表中所有的信息
	public List<recordRpg> selectAll() {
		return recordDao.selectAll();
	}

	//通过id查询存档信息
	public recordRpg selectById(int id) {
		return recordDao.selectById(id);
	}

	//通过userId查询存档信息
	public List<recordRpg> selectByUserId(int userId) {
		return recordDao.selectByUserId(userId);
	}
	
	//通过userId和recordType查询信息
	public recordRpg selectByUserIdAndRecordType(int userId,int recordType){
		return recordDao.selectByUserIdAndRecordType(userId, recordType);
	}

	//通过userName查询存档信息
	public List<recordRpg> selectByUserName(String userName) {
		return recordDao.selectByUserName(userName);
	}

	//通过id查询存档信息用于修改
	public int updateInfoById(int id, recordRpg record) {
		return recordDao.updateInfoById(id, record);
	}

	//增加存档
	//(用于复制/备份)
	public int addRecord(recordRpg record) {
		return recordDao.addRecord(record);
	}
	
	//复制、备份存档
	public int copyRecord(int id){
		recordRpg record=recordDao.selectById(id);
		recordRpg newRecord=new recordRpg();
		newRecord.setUserId(record.getUserId());
		newRecord.setUserName(record.getUserName());
		newRecord.setRecordType(record.getRecordType());
		newRecord.setDataValue(record.getDataValue());
		return recordDao.addRecord(newRecord);
	}

	//通过id删除存档
	public int deleteRecordById(int id) {
		return recordDao.deleteRecordById(id);
	}

	//通过userId删除存档
	//(用于删除用户)
	public int deleteRecordByUserId(int userId) {
		return recordDao.deleteRecordByUserId(userId);
	}
	
}
