package cn.com.rpg.service;

import java.util.List;

import cn.com.rpg.entity.areaRpg;

public interface areaRpgService {
	//�������е�ͼ��Ϣ
	/**
	 * �������е�ͼ��Ϣ
	 * @return List<areaRpg>
	 */
	public List<areaRpg> selectAll();
	
	//ͨ��id���ҵ�ͼ��Ϣ
	/**
	 * ͨ��id���ҵ�ͼ��Ϣ
	 * @param id:int
	 * @return areaRpg
	 */
	public areaRpg selectById(int id);
	 
	//���ӵ�ͼ
	/**
	 * ���ӵ�ͼ
	 * @param area:areaRpg
	 * @return int
	 */
	public int addArea(areaRpg area);
	
	//ͨ��id�޸ĵ�ͼ��Ϣ
	/**
	 * ͨ��id�޸ĵ�ͼ��Ϣ
	 * @param id:int
	 * @param area:areaRpg
	 * @return int
	 */
	public int updateInfoById(int id,areaRpg area);
	
	//ͨ��idɾ����ͼ
	/**
	 * ͨ��idɾ����ͼ
	 * @param id:int
	 * @return int
	 */
	public int deleteAreaById(int id);
}
