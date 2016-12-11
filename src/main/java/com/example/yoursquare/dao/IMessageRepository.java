package com.example.yoursquare.dao;

import java.util.List;

import com.example.yoursquare.model.*;

public interface IMessageRepository extends IRepository<Message> {

	public List<Message> byId(Integer Id);

}
