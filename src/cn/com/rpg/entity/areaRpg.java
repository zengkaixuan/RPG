package cn.com.rpg.entity;

public class areaRpg {
	private int id;	//���
	private String areaName;	//��ͼ��
	private int type;	//��ͼ����,0�����ͼ,1����,2����
	private String summary;	//���
	private String picPath;	//ͼƬλ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	@Override
	public String toString() {
		return "areaRpg [id=" + id + ", areaName=" + areaName + ", type="
				+ type + ", summary=" + summary + ", picPath=" + picPath + "]\n";
	}
	
}
