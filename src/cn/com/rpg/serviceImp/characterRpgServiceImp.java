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

	//查询所有角色信息
	public List<characterRpg> selectAll() {
		return characterDao.selectAll();
	}
	
	//通过id查询角色信息
	public characterRpg selectById(int id){
		return characterDao.selectById(id);
	}
	
	//增加角色
	public int addCharacter(characterRpg character) {
		return characterDao.addCharacter(character);
	}
	
	//通过id修改角色信息
	public int updateInfoById(int id,characterRpg character) {
		return characterDao.updateInfoById(id, character);
	}
	
	//通过id删除角色信息
	public int deleteCharacterById(int id) {
		return characterDao.deleteCharacterById(id);
	}
}
