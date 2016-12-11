package com.example.yoursquare.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.yoursquare.model.Ad;

public class AdMapper implements IMapResultSetIntoEntity<Ad>{

	public Ad map(ResultSet rs) throws SQLException {
		Ad a = new Ad();
		a.setId(rs.getInt("id"));
		a.setTitle(rs.getString("title"));
		a.setFee(rs.getInt("fee"));
		a.setAdress(rs.getString("adress"));
		a.setZipcode(rs.getString("zipcode"));
		a.setCity(rs.getString("city"));
		a.setSpace(rs.getFloat("space"));
		a.setFurnished(rs.getBoolean("furnished"));
		a.setActive(rs.getBoolean("active"));
		a.setAddDate(rs.getString("addDate"));
		a.setEndDate(rs.getString("endDate"));
		a.setRoom(rs.getInt("room"));
		a.setGallery(rs.getString("gallery"));
		a.setContent(rs.getString("content"));
		a.setType(rs.getInt("type"));
		a.setProperty(rs.getInt("property"));
		return a;
	}

}
