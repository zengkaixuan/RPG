package cn.com.rpg.serviceImp;

import java.util.List;

import cn.com.rpg.dao.characterRpgDao;
import cn.com.rpg.daoImp.characterRpgDaoImp;
import cn.com.rpg.entity.characterRpg;
import cn.com.rpg.service.characterRpgService;

public class characterRpgServiceImp implements characterRpgService{
	characterRpgDao characterDao;
	
	public characterRpgServiceImp() {
		characterDao=new characterRpgDaoImp();
	}

	//��ѯ���н�ɫ��Ϣ
	public List<characterRpg> selectAll() {
		return characterDao.selectAll();
	}
	
	//ͨ��id��ѯ��ɫ��Ϣ
	public characterRpg selectById(int id){
		return characterDao.selectById(id);
	}
	
	//���ӽ�ɫ
	public int addCharacter(characterRpg character) {
		return characterDao.addCharacter(character);
	}
	
	//ͨ��id�޸Ľ�ɫ��Ϣ
	public int updateInfoById(int id,characterRpg character) {
		return characterDao.updateInfoById(id, character);
	}
	
	//ͨ��idɾ����ɫ��Ϣ
	public int deleteCharacterById(int id) {
		return characterDao.deleteCharacterById(id);
	}
}
