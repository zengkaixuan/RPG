package cn.com.rpg.entity;

public class recordRpg {
	private int id;	//�浵���
	private int userId;	//��ұ��
	private String userName;	//����û���
	private int recordType;	//�浵����,0ΪRPG Global,1ΪRPG File
	private String dataValue;	//�浵ֵ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRecordType() {
		return recordType;
	}
	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	@Override
	public String toString() {
		return "recordRpg [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", recordType=" + recordType + ", dataValue="
				+ dataValue + "]\n";
	}
	
	
	
}
