package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.*;
import dao.uow.IUnitOfWork;
import model.*;

import java.util.*;

public class UserRepository extends RepositoryBase<User> implements IUserRepository {
	
	
	public UserRepository(Connection connection,
			IMapResultSetIntoEntity<User> mapper,
			IUnitOfWork uow) {
		super(connection, mapper, uow);
	}

	@Override
	protected String tableName() {
		return "user";
	}

	@Override
	protected String createTableSql() {
			return "CREATE TABLE user("
					+ "id INT GENERATED BY DEFAULT AS IDENTITY,"
					+ "name VARCHAR(45),"
					+ "surname VARCHAR(45),"
					+ "email VARCHAR(45),"
					+ "password VARCHAR(45)"
					+ ")";

	}
	
	@Override
	protected String insertSql() {
		return "INSERT INTO user(name,surname,email,password) VALUES(?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE user set name=?, surname=?, email=?, password=? WHERE id=?";
	}


	@Override
	protected void setupInsert(User entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
		insert.setString(3, entity.getEmail());
		insert.setString(4, entity.getPassword());
		
	}

	@Override
	protected void setupUpdate(User entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		update.setString(3, entity.getEmail());
		update.setString(4, entity.getPassword());
		update.setInt(5, entity.getId());
		
}

	public List<User> withName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}