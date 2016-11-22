package model.copy;

import java.sql.Date;

public class Ad {
	
	private int id;
	private String title;
	private int fee;
	private String adress;
	private String city;
	private String zipcode;
	private float space;
	private boolean firnished;
	private boolean active;
	private Date addDate;
	private Date endDate;
	private int room;
	private String gallery;
	private String content;
	
	private enum type {
		SELL, RENT
	}
	private enum property {
		FLAT, ROOM
	}
	
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
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public float getSpace() {
		return space;
	}
	public void setSpace(float space) {
		this.space = space;
	}
	public boolean isFirnished() {
		return firnished;
	}
	public void setFirnished(boolean firnished) {
		this.firnished = firnished;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getGallery() {
		return gallery;
	}
	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
