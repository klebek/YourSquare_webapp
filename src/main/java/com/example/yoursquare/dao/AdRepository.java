package com.example.yoursquare.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.yoursquare.dao.mappers.*;
import com.example.yoursquare.dao.uow.IUnitOfWork;
import com.example.yoursquare.model.*;

import java.util.*;

public class AdRepository extends RepositoryBase<Ad> implements IAdRepository {


	public AdRepository(Connection connection,
						IMapResultSetIntoEntity<Ad> mapper,
						IUnitOfWork uow) {
		super(connection, mapper, uow);
	}
	
	@Override
	protected String tableName() {
		return "ad";
	}
	
	protected String createTableSql() {
		return "CREATE TABLE ad("
					+ "id INT GENERATED BY DEFAULT AS IDENTITY,"
					+ "userId INT"
					+ "title VARCHAR(20),"
					+ "fee INT,"
					+ "adress VARCHAR(20),"
					+ "city VARCHAR(20),"
					+ "zipcode VARCHAR(20),"
					+ "space float,"
					+ "furnished BOOLEAN,"
					+ "active BOOLEAN,"
					+ "addDate DATE,"
					+ "endDate DATE,"
					+ "room INT,"
					+ "gallery VARCHAR(20),"
					+ "content VARCHAR(20),"
					+ "type INT,"
					+ "property INT"
				    + "FOREIGN KEY (userId) REFERENCES user (id),"
				    + ")";
	}

	@Override
	protected String insertSql() {
		return "INSERT INTO ad(title,userId,fee,adress,city,zipcode,space,furnished,active,addDate,endDate,room,gallery,content,type,property) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE ad set userId, title=?, fee=?, adress=?, city=?, zipcode=?, space=?, furnished=?, active=?, addDate=?, endDate=?, room=?, gallery=?, content=?, type=?, property=? WHERE id=?";
	}


	@Override
	protected void setupInsert(Ad entity) throws SQLException {
		insert.setInt(1, entity.getUserId());
		insert.setString(2, entity.getTitle());
		insert.setInt(3, entity.getFee());
		insert.setString(4, entity.getAdress());
		insert.setString(5, entity.getCity());
		insert.setString(6, entity.getZipcode());
		insert.setFloat(7, entity.getSpace());
		insert.setBoolean(8, entity.isFurnished());
		insert.setBoolean(9, entity.isActive());
		insert.setDate(10, entity.getAddDate());
		insert.setDate(11,entity.getEndDate());
		insert.setInt(12, entity.getRoom());
		insert.setString(13, entity.getGallery());
		insert.setString(14, entity.getContent());
		insert.setInt(15, entity.getType());
		insert.setInt(16, entity.getProperty());

		
	}

	@Override
	protected void setupUpdate(Ad entity) throws SQLException {
		insert.setInt(1, entity.getUserId());

		update.setString(2,entity.getTitle());
		update.setInt(3,entity.getFee());
		update.setString(4,entity.getAdress());
		update.setString(5,entity.getCity());
		update.setString(6,entity.getZipcode());
		update.setFloat(7,entity.getSpace());
		update.setBoolean(8,entity.isFurnished());
		update.setBoolean(9,entity.isActive());
		update.setDate(10,entity.getAddDate());
		update.setDate(11,entity.getEndDate());
		update.setInt(12,entity.getRoom());
		update.setString(13,entity.getGallery());
		update.setString(14,entity.getContent());
		update.setInt(15,entity.getType());
		update.setInt(16,entity.getProperty());
	}

	public List<Ad> byUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
