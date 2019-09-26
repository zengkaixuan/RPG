package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.newsRpg;

public interface newsRpgService {
	//��������������Ϣ
	/**
	 * ��������������Ϣ
	 * @return List<newsRpg>
	 */
	public List<newsRpg> selectAll();
	
	//ͨ��id����������Ϣ
	/**
	 * 
	 * @param id:int
	 * @return newsRpg
	 */
	public newsRpg selectById(int id);
	
	//��������
	/**
	 * ��������
	 * @param news:newsRpg
	 * @return int
	 */
	public int addNews(newsRpg news);
	
	//ͨ��id�޸�������Ϣ
	/**
	 * ͨ��id�޸�������Ϣ
	 * @param id:int
	 * @param news:newsRpg
	 * @return int
	 */
	public int updateInfoById(int id,newsRpg news);
	
	//ͨ��idɾ������
	/**
	 * ͨ��idɾ������
	 * @param id:int
	 * @return int
	 */
	public int deleteNewsById(int id);
}
