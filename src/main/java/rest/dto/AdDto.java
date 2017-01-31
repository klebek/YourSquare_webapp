package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

import model.User;

import java.util.List;


@XmlRootElement
public class AdDto {
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private int fee;

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public int getUserId() { return userId; }

	public void setUserId(int userId) { this.userId = userId; }

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public int getFee() { return fee; }

	public void setFee(int fee) { this.fee = fee; }
}
