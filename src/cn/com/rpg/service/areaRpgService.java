package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.areaRpg;

public interface areaRpgService {
	//查找所有地图信息
	/**
	 * 查找所有地图信息
	 * @return List<areaRpg>
	 */
	public List<areaRpg> selectAll();
	
	//通过id查找地图信息
	/**
	 * 通过id查找地图信息
	 * @param id:int
	 * @return areaRpg
	 */
	public areaRpg selectById(int id);
	 
	//增加地图
	/**
	 * 增加地图
	 * @param area:areaRpg
	 * @return int
	 */
	public int addArea(areaRpg area);
	
	//通过id修改地图信息
	/**
	 * 通过id修改地图信息
	 * @param id:int
	 * @param area:areaRpg
	 * @return int
	 */
	public int updateInfoById(int id,areaRpg area);
	
	//通过id删除地图
	/**
	 * 通过id删除地图
	 * @param id:int
	 * @return int
	 */
	public int deleteAreaById(int id);
}
