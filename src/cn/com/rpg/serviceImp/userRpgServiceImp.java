package cn.com.rpg.serviceImp;

import java.util.List;

import cn.com.rpg.dao.userRpgDao;
import cn.com.rpg.daoImp.userRpgDaoImp;
import cn.com.rpg.entity.userRpg;
import cn.com.rpg.service.recordRpgService;
import cn.com.rpg.service.userRpgService;

public class userRpgServiceImp implements userRpgService{
	userRpgDao userDao;
	recordRpgService recordService;
	
	public userRpgServiceImp() {
		userDao=new userRpgDaoImp();
		recordService=new recordRpgServiceImp();
	}

	//��ѯuser_rpg�������е��û�

	public List<userRpg> selectAll(){
		return userDao.selectAll();
	}

	//ͨ��id��ѯ�û�

	public userRpg selectById(int id) {
		return userDao.selectById(id);
	}

	//ͨ���û�����ѯ�û�
	public userRpg selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}
	
	//ͨ���û����Ͳ�ѯ�û�
	public List<userRpg> selectByUserType(int userType) {
		return userDao.selectByUserType(userType);
	}

	//ͨ��vip��ѯ�û�
	public List<userRpg> selectByVip(int vip) {
		return userDao.selectByVip(vip);
	}

	//ͨ��id��ѯ�û������޸��û���Ϣ
	public int updateInfoById(int id, userRpg user) {
		return userDao.updateInfoById(id, user);
	}

	//�����û�
	public int addUser(userRpg user) {
		return userDao.addUser(user);
	}

	//ͨ��idɾ���û�
	public int deleteUser(int id) {
		recordService.deleteRecordByUserId(id);
		return userDao.deleteUser(id);
	}

	@Override
	public boolean insertUser(userRpg user) {
		
		return userDao.insertUser(user);
	}

	@Override
	public int selectByNameAndPwd(String userName, String password) {
		return userDao.selectByNameAndPwd(userName, password);
	}
	
}
