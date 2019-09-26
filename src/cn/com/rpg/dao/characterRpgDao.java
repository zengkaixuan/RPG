package cn.com.rpg.dao;

import java.util.List;

import cn.com.rpg.entity.characterRpg;

public interface characterRpgDao {
	//��ѯ���н�ɫ��Ϣ
	/**
	 * ��ѯ���н�ɫ��Ϣ
	 * @return List<characterRpg>
	 */
	public List<characterRpg> selectAll();
	
	//ͨ��id��ѯ��ɫ��Ϣ
	public characterRpg selectById(int id);
	
	//���ӽ�ɫ
	/**
	 * ���ӽ�ɫ
	 * @param character:characterRpg
	 * @return int
	 */
	public int addCharacter(characterRpg character);
	
	//ͨ��id�޸Ľ�ɫ��Ϣ
	/**
	 * ͨ��id�޸Ľ�ɫ��Ϣ
	 * @param id:int
	 * @param character:characterRpg
	 * @return int
	 */
	public int updateInfoById(int id,characterRpg character);
	
	//ͨ��idɾ����ɫ��Ϣ
	/**
	 * ͨ��idɾ����ɫ��Ϣ
	 * @param id:int
	 * @return int
	 */
	public int deleteCharacterById(int id);
}
