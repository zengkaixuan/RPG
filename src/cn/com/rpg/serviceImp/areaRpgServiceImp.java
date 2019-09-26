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

	//�������е�ͼ��Ϣ
	public List<areaRpg> selectAll() {
		return areaDao.selectAll();
	}
	
	//ͨ��id���ҵ�ͼ��Ϣ
	public areaRpg selectById(int id) {
		return areaDao.selectById(id);
	}
	 
	//���ӵ�ͼ
	public int addArea(areaRpg area) {
		return areaDao.addArea(area);
	}
	
	//ͨ��id�޸ĵ�ͼ��Ϣ
	public int updateInfoById(int id,areaRpg area) {
		return areaDao.updateInfoById(id, area);
	}
	
	//ͨ��idɾ����ͼ
	public int deleteAreaById(int id) {
		return areaDao.deleteAreaById(id);
	}
	
}
