package cn.com.rpg.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.areaRpgDao;
import cn.com.rpg.dao.baseDao;
import cn.com.rpg.entity.areaRpg;

public class areaRpgDaoImp extends baseDao implements areaRpgDao{
	
	//将rs中的属性赋值到areaRpg对象
	/**
	 * 将rs中属性赋值到areaRpg对象
	 * @param rs:ResultSet
	 * @return areaRpg
	 * @throws SQLException
	 */
	public areaRpg setAreaInfo(ResultSet rs) throws SQLException{
		int id=rs.getInt("id");
		String areaName=rs.getString("areaName");
		int type=rs.getInt("type");
		String summary=rs.getString("summary");
		String picPath=rs.getString("picPath");
		
		areaRpg area=new areaRpg();
		area.setId(id);
		area.setAreaName(areaName);
		area.setType(type);
		area.setSummary(summary);
		area.setPicPath(picPath);
		
		return area;
	}
	
	//查找所有地图信息
	public List<areaRpg> selectAll() {
		List<areaRpg> list=new ArrayList<areaRpg>();
		try {
			if(getConnection()){
				String sql="select * from area_rpg";
				Object[] params={};
				rs=selectSql(sql, params);
				while(rs.next()){
					areaRpg area=new areaRpg();
					area=setAreaInfo(rs);
					list.add(area);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	
	//通过id查找地图信息
	public areaRpg selectById(int id) {
		areaRpg area=null;
		try {
			if(getConnection()){
				String sql="select * from area_rpg where id=?";
				Object[] params={id};
				rs=selectSql(sql, params);
				while(rs.next()){
					area=setAreaInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return area;
	}
	 
	//增加地图
	public int addArea(areaRpg area) {
		int a=0;
		try {
			if(getConnection()){
				String sql="insert into area_rpg values(null,?,?,?,?)";
				Object[] params=
					{area.getAreaName(),area.getType(),area.getSummary(),
						area.getPicPath()};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}
	
	//通过id修改地图信息
	public int updateInfoById(int id,areaRpg area) {
		int a=0;
		try {
			if(getConnection()){
				String sql="update area_rpg "
						+ "set areaName=?,type=?,summary=?,picPath=? "
						+ "where id=?";
				Object[] params=
					{area.getAreaName(),area.getType(),area.getSummary(),
						area.getPicPath(),id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}
	
	//通过id删除地图
	public int deleteAreaById(int id) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from area_rpg where id=?";
				Object[] params={id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}

}
