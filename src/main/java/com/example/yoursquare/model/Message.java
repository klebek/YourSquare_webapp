package com.example.yoursquare.model;

import java.sql.Date;

public class Message implements IHaveId {
	
	private int id;
	private int fromUser;
	private int toUser;
	private String title;
	private String content;
	private Date sendDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	

}
