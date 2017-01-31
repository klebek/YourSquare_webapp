package dao;

import java.util.List;

import model.User;

public interface IUserRepository extends IRepository<User> {
	
	public List<User> withName(String name);
}
