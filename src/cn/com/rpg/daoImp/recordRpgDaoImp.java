package cn.com.rpg.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.rpg.dao.baseDao;
import cn.com.rpg.dao.recordRpgDao;
import cn.com.rpg.entity.recordRpg;

public class recordRpgDaoImp extends baseDao implements recordRpgDao{
	//��rs�����Ը�ֵ��recordRpg����
	public recordRpg setRecordInfo(ResultSet rs) throws SQLException{
		int id=rs.getInt("id");
		int userId=rs.getInt("userId");
		String userName=rs.getString("userName");
		int recordType=rs.getInt("recordType") ;
		String dataValue=rs.getString("dataValue");
		recordRpg record=new recordRpg();
		record.setId(id);
		record.setUserId(userId);
		record.setUserName(userName);
		record.setRecordType(recordType);
		record.setDataValue(dataValue);
		return record;
	}
	
	//��ѯrecord_rpg�������е���Ϣ
	public List<recordRpg> selectAll() {
		List<recordRpg> list=new ArrayList<recordRpg>();
		try {
			if (getConnection()) {
				String sql="select * from record_rpg";
				Object[] params={};
				rs=selectSql(sql, params);
				while(rs.next()){
					recordRpg record=setRecordInfo(rs);
					list.add(record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	//ͨ��id��ѯ�浵��Ϣ
	public recordRpg selectById(int id) {
		recordRpg record=null;
		try {
			if (getConnection()) {
				String sql="select * from record_rpg where id=?";
				Object[] params={id};
				rs=selectSql(sql, params);
				while(rs.next()){
					record=setRecordInfo(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return record;
	}

	//ͨ��userId��ѯ�浵��Ϣ
	public List<recordRpg> selectByUserId(int userId) {
		List<recordRpg> list=new ArrayList<recordRpg>();
		try {
			if (getConnection()) {
				String sql="select * from record_rpg where userId=?";
				Object[] params={userId};
				rs=selectSql(sql, params);
				while(rs.next()){
					recordRpg record=setRecordInfo(rs);
					list.add(record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	
	//ͨ��userId��recordType��ѯ��Ϣ
		public recordRpg selectByUserIdAndRecordType(int userId, int recordType) {
			recordRpg record=null;
			try {
				if (getConnection()) {
					String sql="select * from record_rpg where userId=? and recordType=?";
					Object[] params={userId,recordType};
					rs=selectSql(sql, params);
					while(rs.next()){
						record=setRecordInfo(rs);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
			return record;
		}

	//ͨ��userName��ѯ�浵��Ϣ
	public List<recordRpg> selectByUserName(String userName) {
		List<recordRpg> list=new ArrayList<recordRpg>();
		try {
			if (getConnection()) {
				String sql="select * from record_rpg where userName=?";
				Object[] params={userName};
				rs=selectSql(sql, params);
				while(rs.next()){
					recordRpg record=setRecordInfo(rs);
					list.add(record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	//ͨ��id�޸Ĵ浵��Ϣ
	public int updateInfoById(int id, recordRpg record) {
		int a=0;
		try {
			if(getConnection()){
				String sql="update record_rpg "
						+ "set userId=?,userName=?,recordType=?,dataValue=? "
						+ "where id=?";
				Object[] params={record.getUserId(),record.getUserName(),
						record.getRecordType(),record.getDataValue(),id};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}

	//���Ӵ浵
	//(���ڸ���/����)
	public int addRecord(recordRpg record) {
		int a=0;
		try {
			if(getConnection()){
				String sql="insert into record_rpg values(null,?,?,?,?)";
				Object[] params={record.getUserId(),record.getUserName(),
						record.getRecordType(),record.getDataValue()};
				a=updateSQL(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return a;
	}

	//ͨ��idɾ���浵
	public int deleteRecordById(int id) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from record_rpg where id=?";
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

	//ͨ��userIdɾ���浵
	//(����ɾ���û�)
	public int deleteRecordByUserId(int userId) {
		int a=0;
		try {
			if(getConnection()){
				String sql="delete from record_rpg where userId=?";
				Object[] params={userId};
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
