package cn.com.rpg.daoImp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.baseDao;
import cn.com.rpg.dao.newsRpgDao;
import cn.com.rpg.entity.newsRpg;



public class newsRpgDaoImp extends baseDao implements newsRpgDao{
	
	//将rs中属性赋值到newsRpg对象
	/**
	 * 将rs中属性赋值到newsRpg对象
	 * @param rs:ResultSet
	 * @return newsRpg
	 * @throws SQLException
	 */
	public newsRpg setNewsInfo(ResultSet rs) throws SQLException{
		int id=rs.getInt("id");
		String title=rs.getString("title");
		String author=rs.getString("author");
		Date createDate=rs.getDate("createDate");
		String content=rs.getString("content");	
		
		newsRpg news=new newsRpg();
		news.setId(id);
		news.setTitle(title);
		news.setAuthor(author);
		news.setCreateDate(createDate);
		news.setContent(content);
		return news;
	}
	
	//查找所有新闻信息
	public List<newsRpg> selectAll() {
		List<newsRpg> list=new ArrayList<newsRpg>();
		try {
			if(getConnection()){
				String sql="select * from news_rpg";
				Object[] params={};
				rs=selectSql(sql, params);
				while(rs.next()){
					newsRpg news=setNewsInfo(rs);
					list.add(news);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	//通过id查询新闻用于修改新闻信息
	public newsRpg selectById(int id) {
		newsRpg news=null;
		try {
			if(getConnection()){
				String sql="select * from news_rpg where id=?";
				Object[] params={id};
				rs=selectSql(sql, params);
				while(rs.next()){
					news=setNewsInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return news;
	}
	
	//增加新闻
	public int addNews(newsRpg news){
		int a=0;
		try {
			if(getConnection()){
				String sql="insert into news_rpg values(null,?,?,?,?)";
				Object[] params=
					{news.getTitle(),news.getAuthor(),news.getCreateDate(),
						news.getContent()};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}
	
	//通过id修改新闻信息
	public int updateInfoById(int id, newsRpg news) {
		int a=0;
		try {
			if(getConnection()){
				String sql="update news_rpg "
						+ "set title=?,author=?,createDate=?,content=? "
						+ "where id=?";
				Object[] params=
					{news.getTitle(),news.getAuthor(),news.getCreateDate(),
						news.getContent(),id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	//通过id删除新闻
	public int deleteNewsById(int id) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from news_rpg where id=?";
				Object[] params={id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
