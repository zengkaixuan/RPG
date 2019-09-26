package cn.com.rpg.serviceImp;

import java.util.List;

import cn.com.rpg.dao.areaRpgDao;
import cn.com.rpg.daoImp.areaRpgDaoImp;
import cn.com.rpg.entity.areaRpg;
import cn.com.rpg.service.areaRpgService;

public class areaRpgServiceImp implements areaRpgService{
	areaRpgDao areaDao;
	
	public areaRpgServiceImp() {
		areaDao=new areaRpgDaoImp(); 
	}

	//查找所有地图信息
	public List<areaRpg> selectAll() {
		return areaDao.selectAll();
	}
	
	//通过id查找地图信息
	public areaRpg selectById(int id) {
		return areaDao.selectById(id);
	}
	 
	//增加地图
	public int addArea(areaRpg area) {
		return areaDao.addArea(area);
	}
	
	//通过id修改地图信息
	public int updateInfoById(int id,areaRpg area) {
		return areaDao.updateInfoById(id, area);
	}
	
	//通过id删除地图
	public int deleteAreaById(int id) {
		return areaDao.deleteAreaById(id);
	}
	
}
