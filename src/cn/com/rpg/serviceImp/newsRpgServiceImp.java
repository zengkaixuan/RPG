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

	//查找所有新闻信息
	public List<newsRpg> selectAll() {
		return newsDao.selectAll();
	}

	//通过id查找新闻信息
	public newsRpg selectById(int id) {
		return newsDao.selectById(id);
	}

	//增加新闻
	public int addNews(newsRpg news) {
		return newsDao.addNews(news);
	}

	//通过id修改新闻信息
	public int updateInfoById(int id, newsRpg news) {
		return newsDao.updateInfoById(id, news);
	}

	//通过id删除新闻
	public int deleteNewsById(int id) {
		return newsDao.deleteNewsById(id);
	}

}
