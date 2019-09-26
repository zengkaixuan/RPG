package cn.com.rpg.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.baseDao;
import cn.com.rpg.dao.userRpgDao;
import cn.com.rpg.entity.userRpg;

public class userRpgDaoImp extends baseDao implements userRpgDao{
	//��rs�����Ը�ֵ��userRpg����
	/**
	 * ��rs�����Ը�ֵ��userRpg����
	 * @param rs ResultSet
	 * @return userRpg
	 * @throws SQLException 
	 */
	public userRpg setUserInfo(ResultSet rs) throws SQLException{
		int id=rs.getInt("id");
		String userName=rs.getString("userName");
		String password=rs.getString("password");
		int userType=rs.getInt("userType");
		int vip=rs.getInt("vip");
		String email=rs.getString("email");
		String identity=rs.getString("identity");
		userRpg user=new userRpg();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserType(userType);
		user.setVip(vip);
		user.setEmail(email);
		user.setIdentity(identity);
		return user;
	}
	
	//��ѯuser_rpg�������е��û�
	public List<userRpg> selectAll() {
		List<userRpg> list=new ArrayList<userRpg>();
		try {
			if(getConnection()){
				String sql="select * from user_rpg";
				Object[] params={};
				rs=selectSql(sql, params);
				while(rs.next()){
					userRpg user=setUserInfo(rs);
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	
	//ͨ��id��ѯ�û���Ϣ
	public userRpg selectById(int id){
		userRpg user = null;
		try {
			if(getConnection()){
				String sql="select * from user_rpg where id=?";
				Object[] params={id};
				rs=selectSql(sql, params);
				while(rs.next()){
					user=setUserInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return user;
	}
	
	

	//ͨ���û�����ѯ�û�
	public userRpg selectByUserName(String userName) {
		userRpg user = null;
		
		try {
			if(getConnection()){
				String sql="select * from user_rpg where userName=?";
				Object[] params={userName};
				rs=selectSql(sql, params);
				while(rs.next()){
					user=setUserInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return user;
	}

	//ͨ���û����Ͳ�ѯ�û�
	public List<userRpg> selectByUserType(int userType) {
		List<userRpg> list=new ArrayList<userRpg>();
		try {
			if(getConnection()){
				String sql="select * from user_rpg where userType=?";
				Object[] params={userType};
				rs=selectSql(sql, params);
				while(rs.next()){
					userRpg user=setUserInfo(rs);
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		} 
		return list;
	}

	//ͨ��vip��ѯ�û�
	public List<userRpg> selectByVip(int vip) {
		List<userRpg> list=new ArrayList<userRpg>();
		try {
			if(getConnection()){
				String sql="select * from user_rpg where vip=?";
				Object[] params={vip};
				rs=selectSql(sql, params);
				while(rs.next()){
					userRpg user=setUserInfo(rs);
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	//ͨ��id�޸��û���Ϣ
	public int updateInfoById(int id, userRpg user) {
		int a=0;
		try {
			if(getConnection()){
				String sql="update user_rpg "
						+ "set userName=?,password=?,userType=?,"
						+ "vip=?,email=?,identity=? "
						+ "where id=?";
				Object[] params=
					{user.getUserName(),user.getPassword(),
						user.getUserType(),user.getVip(),user.getEmail(),
						user.getIdentity(),id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}
    //�����û���Ϣ
	public int addUser(userRpg user) {
		int a=0;
		try {
			if(getConnection()){
				String sql="insert into user_rpg values(NULL,?,?,1,?,?,?)";
				Object[] params={user.getUserName(),user.getPassword(),
						user.getVip(),user.getEmail(),
						user.getIdentity()};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}
	
	//ͨ��idɾ���û�
	public int deleteUser(int id) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from user_rpg where id=?";
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
	
	//�����û���Ϣ
		public boolean insertUser(userRpg user) {
			boolean flag = false;
			try {
				if(getConnection()){
					String sql="insert into user_rpg(userName,password,email,identity)values(?,?,?,?)";
					Object[] params={user.getUserName(),user.getPassword(),user.getEmail(),user.getIdentity()};
					int i = this.updateSQL(sql, params);
					if(i>0){
						flag = true;
					}
									}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
			return flag;
		}

		@Override
		public int selectByNameAndPwd(String userName, String password) {
			int num = 0;
			try {
				if(getConnection()){
					String sql="select * from user_rpg where userName=? and password=? ";
					Object[] params={userName,password};
					rs=selectSql(sql, params);
					while(rs.next()){
						num++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}		
			return num;
		}

		
	
}
