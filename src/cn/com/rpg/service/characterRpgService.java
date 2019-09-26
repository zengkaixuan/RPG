package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.characterRpg;

public interface characterRpgService {
	//查询所有角色信息
	/**
	 * 查询所有角色信息
	 * @return List<characterRpg>
	 */
	public List<characterRpg> selectAll();
	
	//通过id查询角色信息
	public characterRpg selectById(int id);
		
	//增加角色
	/**
	 * 增加角色
	 * @param character:characterRpg
	 * @return int
	 */
	public int addCharacter(characterRpg character);
	
	//通过id修改角色信息
	/**
	 * 通过id修改角色信息
	 * @param id:int
	 * @param character:characterRpg
	 * @return int
	 */
	public int updateInfoById(int id,characterRpg character);
	
	//通过id删除角色信息
	/**
	 * 通过id删除角色信息
	 * @param id:int
	 * @return int
	 */
	public int deleteCharacterById(int id);
}
