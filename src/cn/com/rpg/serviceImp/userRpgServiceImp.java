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

	//查询user_rpg表中所有的用户

	public List<userRpg> selectAll(){
		return userDao.selectAll();
	}

	//通过id查询用户

	public userRpg selectById(int id) {
		return userDao.selectById(id);
	}

	//通过用户名查询用户
	public userRpg selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}
	
	//通过用户类型查询用户
	public List<userRpg> selectByUserType(int userType) {
		return userDao.selectByUserType(userType);
	}

	//通过vip查询用户
	public List<userRpg> selectByVip(int vip) {
		return userDao.selectByVip(vip);
	}

	//通过id查询用户用于修改用户信息
	public int updateInfoById(int id, userRpg user) {
		return userDao.updateInfoById(id, user);
	}

	//增加用户
	public int addUser(userRpg user) {
		return userDao.addUser(user);
	}

	//通过id删除用户
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
