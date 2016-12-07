package com.example.yoursquare.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.example.yoursquare.model.User;


public class UserRepository {





	
	private Connection connection;
	
	private String createTableSql = "CREATE TABLE user ("
  + "idclient` INT NOT NULL,"
  + "name VARCHAR(45) NULL,"
  + "surname VARCHAR(45) NULL,"
  + "adress VARCHAR(45) NULL,"
  + "zipcode VARCHAR(45) NULL,"
  + "city VARCHAR(45) NULL,"
  + "region VARCHAR(45) NULL,"
  + "country VARCHAR(45) NULL,"
  + "phone VARCHAR(45) NULL,"
  + "email VARCHAR(45) NULL,"
  + "password VARCHAR(45) NOT NULL,"
  + "PRIMARY KEY (idclient))";
  	
	private Statement createTable;

	private String insertSql = "INSERT INTO user(name,surname,adress,zipcode,city,region,country,phone,email,password) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private String deleteSql = "DELETE FROM user WHERE iduser = ?";
	private String updateSql = "UPDATE user set name=?, surname=?, adress=?, zipcode=?, city=?, region=?, country=?, phone=?, email=?, password=? WHERE idclient=?";
	private String selectByIdSql = "SELECT * FROM user WHERE idclient=?";
	private String selectAllSql = "SELECT * FROM user";
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement selectById;
	private PreparedStatement selectAll;
	
	// STATEMENT DONE
	public UserRepository(Connection connection) {
		this.connection = connection;
		
		try {
			createTable = connection.createStatement();
			
			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while(rs.next()){
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("person")){
					tableExists=true;
					break;
				}
			}
			if(!tableExists)
				createTable.executeUpdate(createTableSql);
			insert = connection.prepareStatement(insertSql);
			delete = connection.prepareStatement(deleteSql);	
			update = connection.prepareStatement(updateSql);
			selectById = connection.prepareStatement(selectByIdSql);
			selectAll = connection.prepareStatement(selectAllSql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// GET DONE
	public User get(int Id){
		try{
			
			selectById.setInt(1, Id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				User result = new User();
				result.setId(Id);
				result.setName(rs.getString("name"));
				result.setSurname(rs.getString("surname"));
				result.setAdress(rs.getString("adress"));
				result.setZipcode(rs.getString("zipcode"));
				result.setCity(rs.getString("city"));
				result.setRegion(rs.getString("region"));
				result.setCountry(rs.getString("country"));
				result.setPhone(rs.getString("phone"));
				result.setEmail(rs.getString("email"));
				result.setPassword(rs.getString("password"));
				


				return result;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}

	// ??????
	public List<User> getAll(){
		try{
			List<User> result = new ArrayList<User>();
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){
				User p = new User();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				result.add(p);
			}
			return result;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	// DELETE DONE
	public void delete(User p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	// ADD DONE
	public void add(User p){
		try{
			
			insert.setString(1, p.getName());
			insert.setString(2, p.getSurname());
			insert.setString(1, p.getAdress());
			insert.setString(1, p.getZipcode());
			insert.setString(1, p.getCity());
			insert.setString(1, p.getRegion());
			insert.setString(1, p.getCountry());
			insert.setString(1, p.getPhone());
			insert.setString(1, p.getEmail());
			insert.setString(1, p.getPassword());
		


			insert.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	// UPDATE DONE
	public void update(User p){
		try{
			
			update.setString(1, p.getName());
			update.setString(2, p.getSurname());
			update.setString(3, p.getAdress());
			update.setString(4, p.getZipcode());
			update.setString(5, p.getCity());
			update.setString(6, p.getRegion());
			update.setString(7, p.getCountry());
			update.setString(8, p.getPhone());
			update.setString(9, p.getEmail());
			update.setString(10, p.getPassword());
			update.setInt(11, p.getId());
			update.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}