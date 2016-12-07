package com.example.yoursquare.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.yoursquare.dao.*;
import com.example.yoursquare.model.*;

public interface IMapResultSetIntoEntity<TEntity extends IHaveId> {

	public TEntity map(ResultSet rs) throws SQLException;
	
}