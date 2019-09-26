package cn.com.rpg.serviceImp;

import java.util.List;

import cn.com.rpg.dao.newsRpgDao;
import cn.com.rpg.daoImp.newsRpgDaoImp;
import cn.com.rpg.entity.newsRpg;
import cn.com.rpg.service.newsRpgService;

public class newsRpgServiceImp implements newsRpgService{
	newsRpgDao newsDao;
	
	public newsRpgServiceImp() {
		newsDao=new newsRpgDaoImp();
	}

	//��������������Ϣ
	public List<newsRpg> selectAll() {
		return newsDao.selectAll();
	}

	//ͨ��id����������Ϣ
	public newsRpg selectById(int id) {
		return newsDao.selectById(id);
	}

	//��������
	public int addNews(newsRpg news) {
		return newsDao.addNews(news);
	}

	//ͨ��id�޸�������Ϣ
	public int updateInfoById(int id, newsRpg news) {
		return newsDao.updateInfoById(id, news);
	}

	//ͨ��idɾ������
	public int deleteNewsById(int id) {
		return newsDao.deleteNewsById(id);
	}

}
