package com.example.yoursquare.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.yoursquare.model.*;

public class UserMapper implements IMapResultSetIntoEntity<User>{

	public User map(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setSurname(rs.getString("surname"));
		u.setAdress(rs.getString("adress"));
		u.setZipcode(rs.getString("zipcode"));
		u.setCity(rs.getString("city"));
		u.setRegion(rs.getString("region"));
		u.setCountry(rs.getString("country"));
		u.setPhone(rs.getString("phone"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		return u;
	}

}
