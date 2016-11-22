package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;
import model.Ad;


public class AdRepository {





	
	private Connection connection;
	
	private String createTableSql = "CREATE TABLE ad ("
  + "idad INT NOT NULL AUTO_INCREMENT,"
  + "type ENUM('rent', 'sell') NULL,"
  + "title VARCHAR(45) NULL,"
  + "fee INT NULL,"
  + "adress VARCHAR(45) NULL,"
  + "city VARCHAR(45) NULL,"
  + "zipcode VARCHAR(45) NULL,"
  + "space FLOAT NULL,"
  + "furnished TINYINT(1) NULL,"
  + "active TINYINT(1) NULL,"
  + "addDate DATETIME NULL,"
  + "endDate DATETIME NULL,"
  + "room INT NULL,"
  + "gallery VARCHAR(45) NULL,"
  + "client_idclient INT NOT NULL,"
  + "content VARCHAR(255) NULL,"
  + "property ENUM('room', 'flat') NULL,"
  + "PRIMARY KEY (`idad`),"
  +" INDEX `fk_ad_client_idx` (`client_idclient` ASC),"
  + "CONSTRAINT `fk_ad_client`"
  + "FOREIGN KEY (`client_idclient`)"
  + "REFERENCES `workdb`.`user` (`idclient`)";
  	
	private Statement createTable;

	private String insertSql = "INSERT INTO ad (type,type,title,fee,adress,city,zipcode,space,furnished,active,addDate,endDate,room,gallery,client_idclient,content,property) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String deleteSql = "DELETE FROM ad WHERE idad = ?";
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	
	public AdRepository(Connection connection) {
		this.connection = connection;
		
		try {
			createTable = connection.createStatement();
			
			boolean tableExists = false;
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			while(rs.next()){
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("message")){
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
	
	public void delete(AdRepository p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(AdRepository p){
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