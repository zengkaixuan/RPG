package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.newsRpg;

public interface newsRpgService {
	//查找所有新闻信息
	/**
	 * 查找所有新闻信息
	 * @return List<newsRpg>
	 */
	public List<newsRpg> selectAll();
	
	//通过id查找新闻信息
	/**
	 * 
	 * @param id:int
	 * @return newsRpg
	 */
	public newsRpg selectById(int id);
	
	//增加新闻
	/**
	 * 增加新闻
	 * @param news:newsRpg
	 * @return int
	 */
	public int addNews(newsRpg news);
	
	//通过id修改新闻信息
	/**
	 * 通过id修改新闻信息
	 * @param id:int
	 * @param news:newsRpg
	 * @return int
	 */
	public int updateInfoById(int id,newsRpg news);
	
	//通过id删除新闻
	/**
	 * 通过id删除新闻
	 * @param id:int
	 * @return int
	 */
	public int deleteNewsById(int id);
}
