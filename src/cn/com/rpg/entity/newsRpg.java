package cn.com.rpg.entity;

import java.sql.Date;


public class newsRpg {
	private int id;	//���ű��
	private String title;	//���ű���
	private String author;	//��������
	private Date createDate;	//��������
	private String content;	//��������
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return "newsRpg [id=" + id + ", title=" + title + ", author=" + author
				+ ", createDate=" + createDate + ", content=" + content + "]\n";
	}
	
}
