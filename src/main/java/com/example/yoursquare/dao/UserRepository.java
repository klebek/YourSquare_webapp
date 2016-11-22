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
	private String updateSql = "UPDATE user set name=?, surname=?, adress=?, zipcode=?, city=?, region=?, country=?, phone=?, email=?, active=?, password=?, admin=? WHERE idclient=?";
	private String selectByIdSql = "SELECT * FROM user WHERE idclient=?";
	private String selectAllSql = "SELECT * FROM user";
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement selectById;
	private PreparedStatement selectAll;
	
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

	public User get(int userId){
		try{
			
			selectById.setInt(1, userId);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				User result = new User();
				result.setId(userId);
				result.setName(rs.getString("name"));
				result.setSurname(rs.getString("surname"));
				return result;
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<Person> getAll(){
		try{
			List<Person> result = new ArrayList<Person>();
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){
				Person p = new Person();
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
	
	public void delete(Person p){
		try{
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(Person p){
		try{
			
			insert.setString(1, p.getName());
			insert.setString(2, p.getSurname());
			insert.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	public void update(Person p){
		try{
			
			update.setString(1, p.getName());
			update.setString(2, p.getSurname());
			update.setInt(3, p.getId());
			update.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}