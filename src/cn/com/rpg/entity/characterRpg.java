package cn.com.rpg.entity;

public class characterRpg {
	private int id;	//���
	private String name;	//��ɫ��
	private int height;	//��ɫ���
	private int weight;	//��ɫ����
	private String job;	//��ɫְҵ
	private String bloodType;	//��ɫѪ��
	private String profile;	//��ɫ����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "characterRpg [id=" + id + ", name=" + name + ", height="
				+ height + ", weight=" + weight + ", job=" + job
				+ ", bloodType=" + bloodType + ", profile=" + profile + "]\n";
	}
	
	
}
