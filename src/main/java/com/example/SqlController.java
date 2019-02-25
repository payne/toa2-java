package com.example;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class SqlController {
	@Autowired
	 DataSource dataSource;
	
	 void executeSql(String sql) {
		 try (Connection connection = dataSource.getConnection()) {
		      Statement stmt = connection.createStatement();
		      stmt.executeUpdate(sql);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	}
}
