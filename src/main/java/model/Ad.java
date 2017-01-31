package model;

import java.util.List;

import javax.persistence.*;



@Entity
@NamedQueries({
		@NamedQuery(name = "ad.all", query = "SELECT a FROM Ad a"),
		@NamedQuery(name = "ad.id", query = "SELECT a FROM Ad a WHERE a.id=:id"),
		@NamedQuery(name = "ad.byUser", query = "SELECT a FROM Ad a where a.user.id=:user_Id")

})

public class Ad implements IHaveId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	@ManyToOne
	private User user;

	private String title;
	private int fee;
	private String content;

	public int getUserId() { return userId; }

	public void setUserId(int userId) { this.userId = userId; }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }

	public int getFee() { return fee; }

	public void setFee(int fee) { this.fee = fee; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }


}
