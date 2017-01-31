package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import model.Ad;
import model.User;

public class AdMapper implements IMapResultSetIntoEntity<Ad>{

	IRepository<User> userRepo;

	public IRepository<User> getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(IRepository<User> userRepo) {
		this.userRepo = userRepo;
	}

	public Ad map(ResultSet rs) throws SQLException {
		Ad a = new Ad();
		a.setId(rs.getInt("id"));
		a.setUserId(rs.getInt("userid"));
		a.setTitle(rs.getString("title"));
		a.setTitle(rs.getString("content"));
		a.setFee(rs.getInt("fee"));
		if(userRepo!=null)
			a.setUser(this.userRepo.get(a.getUserId()));
		return a;
	}

}
