package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;
import model.Ad;


public class MessageRepository {





	
	private Connection connection;
	
	private String createTableSql = "CREATE TABLE message ("
  + "idmessage INT NOT NULL AUTO_INCREMENT,"
  + "fromUser VARCHAR(45) NULL,"
  + "toUser VARCHAR(45) NULL,"
  + "tittle VARCHAR(45) NULL,"
  + "content VARCHAR(255) NULL,"
  + "sendDate DATETIME NULL,PRIMARY KEY (idmessage))";
  	
	private Statement createTable;

	private String insertSql = "INSERT INTO message(fromUser,toUser,tittle,content,sendDate) VALUES(?,?,?,?,?)";
	private String deleteSql = "DELETE FROM message WHERE idmessage = ?";
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	
	public MessageRepository(Connection connection) {
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
	
	public void delete(MessageRepository p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(MessageRepository p){
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