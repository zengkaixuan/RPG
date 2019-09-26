package cn.com.rpg.entity;

public class areaRpg {
	private int id;	//编号
	private String areaName;	//地图名
	private int type;	//地图类型,0世界地图,1城镇,2地牢
	private String summary;	//简介
	private String picPath;	//图片位置
	
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
