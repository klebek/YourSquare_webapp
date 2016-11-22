package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;
import model.Ad;


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
  + "active ENUM('Y', 'N') NULL DEFAULT 'N',"
  + "token VARCHAR(45) NULL,"
  + "sex ENUM('W', 'M') NULL,"
  + "password VARCHAR(45) NOT NULL,"
  + "admin TINYINT(1) NULL DEFAULT 0,"
  + "PRIMARY KEY (idclient))";
  	
	private Statement createTable;

	private String insertSql = "INSERT INTO user(name,surname,adress,zipcode,city,region,country,phone,email,token,sex,password,admin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String deleteSql = "DELETE FROM user WHERE iduser = ?";
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	
	public UserRepository(Connection connection) {
		this.connection = connection;
		
		try {
			createTable = connection.createStatement();
			
			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while(rs.next()){
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("user")){
					tableExists=true;
					break;
				}
			}
			if(!tableExists)
				createTable.executeUpdate(createTableSql);
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(UserRepository p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(UserRepository p){
		try{
			
			insert.setString(1, p.getDate().toString());
			insert.setDouble(2, p.getAmount());
			insert.setInt(3, p.getFrom().getId());
			insert.setInt(4, p.getTo().getId());
			insert.setDouble(5, p.getRate());
			insert.setInt(6, p.getType().ordinal());
			insert.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
}