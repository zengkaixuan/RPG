package cn.com.rpg.entity;

public class userRpg {
	private int id;	//编号
	private String userName;	//用户名
	private String password;	//用户密码
	private int userType;	//用户类型,0表示管理员,1表示用户
	private int vip;	//vip类型,0表示不是vip,1表示是vip
	private String email;	//邮箱
	private String identity;	//身份证
	
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
