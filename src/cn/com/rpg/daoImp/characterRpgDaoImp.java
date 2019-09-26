package cn.com.rpg.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.baseDao;
import cn.com.rpg.dao.characterRpgDao;
import cn.com.rpg.entity.characterRpg;

public class characterRpgDaoImp extends baseDao implements characterRpgDao{

	//��rs�����Ը�ֵ��characterRpg����
	/**
	 * ��rs�����Ը�ֵ��newsRpg����
	 * @param rs:ResultSet
	 * @return newsRpg
	 * @throws SQLException
	 */
	public characterRpg setCharacterInfo(ResultSet rs) throws SQLException{
		int id=rs.getInt("id");
		String name=rs.getString("name");
		int height=rs.getInt("height");
		int weight=rs.getInt("weight");
		String job=rs.getString("job");
		String bloodType=rs.getString("bloodType");
		String profile=rs.getString("profile");	
		
		characterRpg character=new characterRpg();
		character.setId(id);
		character.setName(name);
		character.setHeight(height);
		character.setWeight(weight);
		character.setJob(job);
		character.setBloodType(bloodType);
		character.setProfile(profile);
		return character;
	}
	
	//��ѯ���н�ɫ��Ϣ
	public List<characterRpg> selectAll() {
		List<characterRpg> list=new ArrayList<characterRpg>();
		try {
			if(getConnection()){
				String sql="select * from character_rpg";
				Object[] params={};
				rs=selectSql(sql, params);
				while(rs.next()){
					characterRpg character=setCharacterInfo(rs);
					list.add(character);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	
	//ͨ��id��ѯ��ɫ��Ϣ
	public characterRpg selectById(int id) {
		characterRpg character=null;
		try {
			if(getConnection()){
				String sql="select * from character_rpg where id=?";
				Object[] params={id};
				rs=selectSql(sql, params);
				while(rs.next()){
					character=setCharacterInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return character;
	}

	//���ӽ�ɫ
	public int addCharacter(characterRpg character) {
		int a=0;
		try {
			if(getConnection()){
				String sql="insert into character_rpg values(null,?,?,?,?,?,?)";
				Object[] params=
					{character.getName(),character.getHeight(),
						character.getWeight(),character.getJob(),
						character.getBloodType(),character.getProfile()};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}

	//ͨ��id�޸Ľ�ɫ��Ϣ
	public int updateInfoById(int id, characterRpg character) {
		int a=0;
		try {
			if(getConnection()){
				String sql="update character_rpg "
						+ "set name=?,height=?,weight=?,"
						+ "job=?,bloodType=?,profile=?"
						+ "where id=?";
				Object[] params=
					{character.getName(),character.getHeight(),
						character.getWeight(),character.getJob(),
						character.getBloodType(),character.getProfile()
						,id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}

	//ͨ��idɾ����ɫ��Ϣ
	public int deleteCharacterById(int id) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from character_rpg where id=?";
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
