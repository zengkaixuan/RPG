package cn.com.rpg.entity;

public class userRpg {
	private int id;	//���
	private String userName;	//�û���
	private String password;	//�û�����
	private int userType;	//�û�����,0��ʾ����Ա,1��ʾ�û�
	private int vip;	//vip����,0��ʾ����vip,1��ʾ��vip
	private String email;	//����
	private String identity;	//���֤
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String toString() {
		return "userRpg [id=" + id + ", userName=" + userName + ", password="
				+ password + ", userType=" + userType + ", vip=" + vip
				+ ", email=" + email + ", identity=" + identity + "]\n";
	}
	
}
